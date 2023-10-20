import socket
import cv2
import sys
from pyzbar.pyzbar import decode, ZBarSymbol

# Initialize the webcam
cap = cv2.VideoCapture(0)  # 0 represents the default webcam

# Define the code types you want to detect
code_types = [ZBarSymbol.EAN13, ZBarSymbol.UPCA, ZBarSymbol.DATABAR, ZBarSymbol.CODE128, ZBarSymbol.QRCODE]

# Connect to the Java application using a socket
host = 'localhost'  # Update this with the Java application's host
port = 12345        # Update this with the Java application's port

socket_client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
socket_client.connect((host, port))

while True:
    ret, frame = cap.read()
    if not ret:
        break

    # Detect barcodes and QR codes of the specified types
    decoded_objects = decode(frame, symbols=code_types)

    for obj in decoded_objects:
        barcode_data = obj.data.decode('utf-8')
        obj_type = obj.type

        # Get the location of the detected code
        points = obj.polygon
        if points:
            # Draw a green box around the detected code
            for j in range(len(points)):
                cv2.line(frame, points[j], points[(j+1) % len(points)], (0, 255, 0), 3)

        # Send the detected code to the Java application
        if obj_type == "QRCODE":
            socket_client.send(f"{obj_type} {barcode_data}\n".encode())
        else:
            socket_client.send(f"{barcode_data}\n".encode())

        # You can perform additional actions based on the decoded data here
        # For example, you can save it to a file or use it in your application

    # Display the frame with detected codes
    cv2.imshow('Code Detector', frame)

    # Press 'Esc' to exit
    if cv2.waitKey(1) & 0xFF == 27:
        break

# Release the webcam and close the window
cap.release()
cv2.destroyAllWindows()

# Send a "Done" message to indicate the end of data
socket_client.send("Done\n".encode())
socket_client.close()
