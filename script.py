# requires pySerial to be installed
import serial

serial_port = "COM3"
baud_rate = 9600
write_to_file_path = "data.txt"

output_file = open(write_to_file_path, "w+")
ser = serial.Serial(serial_port, baud_rate)
while True:
    line = ser.readline()
    if not (line == ""):
        print(line.rstrip())
        output_file.write(line.rstrip()+"\n")
# Check for a solution to close the file, as it causes problems to write values the second time.
# Maybe we could check for a buffer, that would swap the writing file each XX seconds/minutes