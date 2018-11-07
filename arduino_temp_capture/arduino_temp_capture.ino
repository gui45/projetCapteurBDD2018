#include <math.h>

int analogValue;
int B;
float resistance;
float temperature;

void setup()
{
  B = 4275;
  Serial.begin(9600);
}

void loop()
{
  analogValue = analogRead(A0);
  resistance=(float)(1023-analogValue)*10000/analogValue;
  
  temperature = 1/(log(resistance/10000)/B+1/298.15)-273.15;
  
  delay(100);
  Serial.print(temperature);
  Serial.println("");
}
