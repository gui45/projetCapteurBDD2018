#include <math.h>

int B;
float R0;

void setup()
{
  B = 4275;
  R0 = 100000;
  Serial.begin(9600);
}

void loop()
{
  int analogValue = analogRead(A0);
  
  float R = 1023.0/analogValue-1.0;
  R = R0*R;
  
  float temperature = 1.0/(log(R/R0)/B+1/298.15)-273.15;

  delay(100);
  Serial.print(temperature);
  Serial.println("");
}
