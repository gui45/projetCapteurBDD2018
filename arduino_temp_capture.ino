#include <math.h>

int analogValue;
float temperature;
int B;
float resistance;

void setup()
{
  analogValue = 0;
  temperature = 0.0;
  B = 3975;
  resistance = 0.0;
  Serial.begin(9600);
}

void loop()
{
  analogValue = analogRead(0);
  resistance = (float)(1023-analogValue)*10000/analogValue;
  temperature = 1/(log(resistance/10000)/B+1/298.15)-273.15;
  delay(250);
  Serial.print(temperature);
  Serial.println("");
}
