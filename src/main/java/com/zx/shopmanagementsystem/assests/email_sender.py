import smtplib
from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
from email.mime.base import MIMEBase
from email import encoders
import sys

try:
    #Extract command-line arguments
    to_email = sys.argv[1]
    email_from = sys.argv[2]
    subject = sys.argv[3]
    message = sys.argv[4]
    filePath = sys.argv[5]

    # to_email = "usepersonal922@gmail.com"
    # subject = "Email Subject"
    # message = "Email Body"
    # filePath = "C:/Users/Aruna Chinthaka/Documents/NetBeansProjects/WebBarcode/src/main/java/zip_and_mail/zip.zip"

    print(filePath, message, subject, to_email)

    # Setup port number and server name
    smtp_port = 587                 # Standard secure SMTP port
    smtp_server = "smtp.gmail.com"  # Google SMTP Server

    # Set up the email lists
    #email_from = "arunachinthaka99@gmail.com"
    email_list = [to_email]

    # Define the password
    pswd = "icxyxxqmkvgwgxzn"

    # Make the body of the email
    body = f"""
    {message}
    """

    # make a MIME object to define parts of the email
    msg = MIMEMultipart()
    msg['From'] = email_from
    msg['To'] = to_email
    msg['Subject'] = subject

    # Attach the body of the message
    msg.attach(MIMEText(body, 'plain'))

    # Define the file to attach
    filename = filePath.split("/")[-1]  # Extract the filename from the path

    # Open the file in python as a binary
    attachment = open(filePath, 'rb')  # r for read and b for binary

    # Encode as base 64
    attachment_package = MIMEBase('application', 'octet-stream')
    attachment_package.set_payload((attachment).read())
    encoders.encode_base64(attachment_package)
    attachment_package.add_header('Content-Disposition', "attachment; filename= " + filename)
    msg.attach(attachment_package)

    # Cast as string
    text = msg.as_string()

    # Connect with the server
    print("Connecting to the server...")
    TIE_server = smtplib.SMTP(smtp_server, smtp_port)
    TIE_server.starttls()
    TIE_server.login(email_from, pswd)
    print("Successfully connected to the server")
    print()

    # Send emails to "person" as the list is iterated
    print(f"Sending email to: {to_email}...")
    TIE_server.sendmail(email_from, to_email, text)
    print(f"Email sent to: {to_email}")
    print()

    # Close the port
    TIE_server.quit()

    # Exit with code 0 for success
    sys.exit(0)

except Exception as e:
    # Print the exception details
    print(f"Error: {e}")

    # Exit with code 1 for error
    sys.exit(1)
