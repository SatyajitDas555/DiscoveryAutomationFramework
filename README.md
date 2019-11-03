## Selenium TestNg Automation Sample Framework

Environment: <br />
Tested Chrome Browser Version: 78 <br />
OS: Windows <br />

Automated Scenarios:Task One
1.Navigate to https://go.discovery.com/ <br />
2.Select “See All Shows” available in “Shows” tab <br />
3.Wait till the page loads and then select the shows which contain “APOLLO” <br />
4.Verify the Favorites (+ or -) status. <br />
5.If it is already set i.e. “-”, do unfavorite and icon should change to i.e. “+”. <br />
6.If it is not set i.e. “+”, do favorite and icon should change to i.e. “-” <br />
7.Store all the favorite or unfavorite done titles in list. <br />
8.Once favorite or unfavorite is done, goto “My Videos”. <br />
9.Validate the favorite or unfavorite titles under “FAVORITE SHOWS" <br />

How to run the sample suite 

Step-1 : Go to the working directory or root directory where pom.xml is present 
and run below command

```
mvn clean test
```
## Default TestNg Report
Please check emailable-report.html (default TestNg report) inside test-output folder

## Extent Report
Path : Root Directory --> target folder --> html folder --> Extent*.html <br />
Please open in any browser and evaluate the report with the detail information