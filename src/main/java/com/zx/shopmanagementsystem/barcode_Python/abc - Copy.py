import cv2
from pyzbar.pyzbar import decode, ZBarSymbol

# Initialize the webcam with a smaller frame size
cap = cv2.VideoCapture(0)  # 0 represents the default webcam

# Set the frame width and height
cap.set(3, 300)  # Set the width to 640 pixels
cap.set(4, 300)  # Set the height to 480 pixels

# Define the code types you want to detect
code_types = [ZBarSymbol.EAN13, ZBarSymbol.UPCA, ZBarSymbol.DATABAR, ZBarSymbol.CODE128, ZBarSymbol.QRCODE]

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
                cv2.line(frame, points[j], points[(j + 1) % len(points)], (0, 255, 0), 3)

        # Print the detected code
        if obj_type == "QRCODE":
            print(f"{barcode_data}")
        else:
            print(f"{barcode_data}")

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

# Print a "Done" message to indicate the end of data
print("Done")
