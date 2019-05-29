Run Sum2Car:
- Using eclipse: Main.java -> Run As -> Run configurations
Program arguments --carsCount 50 -prop src\configurations\simulator\sanfrancisco.properties --useDynamicTrafficLights --activeApps=ROUTING,TRAFFIC_LIGHT_CONTROL
VM arguments -Xms4048m -Xmx4048 (for a big number of cars)

Check model\parameters\Globals.java for other parameters.
E.g.
	--circleTrafficLight true
	--showGUI false
	--showServers true
	--useDynamicTrafficLights
	--useTrafficLights
	
The program will automatically download and extract car traces at first run. After this, copy trafficLights_sanfrancisco.txt to <project_folder>\processeddata\maps\XmlSanFrancisco
Traces folder: <project folder>\processeddata\traces\sanfrancisco\InterpolatedSanFrancisco
Traffic lights folder: <project_folder>\processeddata\maps\XmlSanFrancisco
See config file: configurations\simulator\sanfrancisco.properties

Obs: You can run SimCar using traces from three cities: San Francisco, Beijing, Rome:
-prop src\configurations\simulator\sanfrancisco.properties
-prop src\configurations\simulator\rome.properties
-prop src\configurations\simulator\beijing.properties
