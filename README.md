## Selenium TestNg Automation Sample Framework

Environment:
Tested Chrome Browser Version: 78
OS: Windows

Automated Scenarios:Task One
1.Navigate to https://go.discovery.com/
2.Select “See All Shows” available in “Shows” tab
3.Wait till the page loads and then select the shows which contain “APOLLO”
4.Verify the Favorites (+ or -) status.
5.If it is already set i.e. “-”, do unfavorite and icon should change to i.e. “+”.
6.If it is not set i.e. “+”, do favorite and icon should change to i.e. “-”
7.Store all the favorite or unfavorite done titles in list.
8.Once favorite or unfavorite is done, goto “My Videos”.
9.Validate the favorite or unfavorite titles under “FAVORITE SHOWS"

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