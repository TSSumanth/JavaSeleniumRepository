Selenium Grid:


Hud Configuration: 
------------------

java -jar selenium-server-standalone-3.141.59.jar -role hub

http://localhost:4444/grid/console

Node Configuration:
-------------------

java -Dwebdriver.chrome.driver="D:\Selenium\chromedriver_win32\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://192.168.1.6:4444/grid/register -port 5566

you can ignore port.
