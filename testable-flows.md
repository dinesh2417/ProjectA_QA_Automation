
# ProjectA – TestFlow / TestScenario Document
## HomePage/SearchPage Test
####Test Scenario 1: UI validation of the homepage
###### Test case 1: Check whether the header displays properly
*  **Test case id :** TC_UI_HP_S01_P01
*  **User Story id :**  N/A
*  **Description :** Check whether the header displays properly or not once the URL is entered
*  **Automated :** Yes
*  **Priority :** Low
*  **Prerequisite :** Application should be up and running
*  **Test data:** N/A
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter
*  **Expected Result :** <br/>
    1. Header ‘Get Github Repos’ should be displayed at the top center


###### Test case 2: Check whether the search box displays properly with label and accepts text
*  **Test case id :** TC_UI_HP_S01_P02
*  **User Story id :**  N/A
*  **Description :** Check whether the search box displays properly with proper label and whether it accepts text, once the URL is entered
*  **Automated :** No
*  **Priority :** High
*  **Prerequisite :** Application should be up and running
*  **Test data:** N/A
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter
*  **Expected Result :** <br/>
    1. Search box with label ‘Github Username’ on top should be displayed<br/>
    2. Search box should accepts all the values i.e. alphanumeric, special characters, spaces, blanks<br/>
    3. Search box should not be case sensitive <br/>
    4. Search box should accepts minimum of 39 characters (since 39 is the maximum username size of Github)


###### Test case 3: Check whether the Go button displays properly with label and works fine
*  **Test case id :** TC_UI_HP_S01_P03
*  **User Story id :**  N/A
*  **Description :** Check whether the Go button displays properly with label and works fine, once the Go button is clicked
*  **Automated :** No
*  **Priority :** medium
*  **Prerequisite :** Application should be up and running
*  **Test data:** N/A
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter<br/>
    2. Enter the text in the Search Username search box<br/>
    3. Click ‘Go’
*  **Expected Result :** <br/>
    1. Go button should be highlighted during mouse hover on it<br/>
    2. Button press be properly visible with different color or darkening/lightening of the same color<br/>
    3. Either success or failure message should be shown once clicked


###### Test case 4: Check whether the search result messages are displaying properly 
*  **Test case id :** TC_UI_HP_S01_P04
*  **User Story id :**  N/A
*  **Description :** Check whether the search results messages are displaying properly once the Go button is clicked
*  **Automated :** No
*  **Priority :** low
*  **Prerequisite :** Application should be up and running
*  **Test data:** N/A
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter<br/>
    2. Enter the text in the Search Username search box<br/>
    3. Click ‘Go’
*  **Expected Result :** <br/>
    1. ‘Success’ message should be displayed for valid Username in Green color<br/>
    2. ‘Github user not found’ message should be displayed for invalid/not existing Username in Red color


###### Test case 5: Check whether the search results are displaying properly 
*  **Test case id :** TC_UI_HP_S01_P05
*  **User Story id :**  N/A
*  **Description :** Check whether the search results are displaying properly once the Go button is clicked
*  **Automated :** No
*  **Priority :** Medium
*  **Prerequisite :** Application should be up and running
*  **Test data:** N/A
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter<br/>
    2. Enter the text in the Search Username search box<br/>
    3. Click ‘Go’
*  **Expected Result :** <br/>
    1. ‘No repos’ should be displayed for invalid/not existing Username in Red color<br/>
    2. ‘Found N Repos’  should be displayed for valid Username with N as number of repos<br/>
    3. All the repo links should be displayed in blue color at the left bottom<br/>
    4. Links should be clickable<br/>
    5. All the repo description should be displayed at the right bottom



#### Test Scenario 2: Search result with valid/existing username
###### Test case 1: Check whether the search result with valid/existing username works properly
*  **Test case id :** TC_UI_HP_S02_P01
*  **User Story id :**  N/A
*  **Description :** Check whether the search result with valid/existing username works properly
*  **Automated :** Yes
*  **Priority :** High
*  **Prerequisite :** <br/>
    1. Application should be up and running<br/>
    2. Repo with given username should be available in Github
*  **Test data:** e.g. git
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter<br/>
    2. Enter the text in the Search Username search box
    3. Click ‘Go’
*  **Expected Result :** <br/>
    1. ‘Found N Repos’  should be displayed for valid Username with N as number of repos<br/> 
    2. All the repo links should be displayed and clickable<br/>
    3. Repo links/name should be displayed left side and the corresponding description in the right<br/>
    3. Repo list displayed should be equal to the number of repos(N) displayed<br/>
    4. Get Github webservice API should return 200 response code with response body containing the Github list
    5. Number of Repo list displayed should be equal to the number of repos list received by the Get GithubUserRepo webservice 


###### Test case 2: Check whether the Github repo links displayed are working properly
*  **Test case id :** TC_UI_HP_S02_P02
*  **User Story id :**  N/A
*  **Description :** Check whether the Github repo links displayed are working properly
*  **Automated :** Yes
*  **Priority :** High
*  **Prerequisite :** <br/>
    1. Application should be up and running<br/>
    2. Repo with given username should be available in Github
*  **Test data:** e.g. git
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter<br/>
    2. Enter the text in the Search Username search box<br/>
    3. Click ‘Go’<br/>
    4. Click any of the displayed repo link
*  **Expected Result :** <br/>
    1. New tab should be opened with the github URL<br/>
    2. URL should contains the given username



#### Test Scenario 3: Search result with non-existing username
###### Test case 1: Check whether the search result with non-existing username returns error
*  **Test case id :** TC_UI_HP_S03_N01
*  **User Story id :**  N/A
*  **Description :** Check whether the search result with non-existing username returns error
*  **Automated :** Yes
*  **Priority :** High
*  **Prerequisite :** <br/>
    1. Application should be up and running<br/>
    2. Given username should not be available in Github
*  **Test data:** e.g. $”§$&/&((()/(&//&
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter<br/>
    2. Enter the text in the Search Username search box<br/>
    3. Click ‘Go’
*  **Expected Result :** <br/>
    1. ‘Github user not found’ message should be displayed<br/>
    2. Get Github webservice API should return 404 response code
    3. ‘No repos’ should be displayed as repo list header<br/>
    4. No repo links should be displayed


###### Test case 2: Check whether the search result with username as blank returns error
*  **Test case id :** TC_UI_HP_S03_N02
*  **User Story id :**  N/A
*  **Description :** Check whether the search result with username as blank returns error
*  **Automated :** No
*  **Priority :** Medium
*  **Prerequisite :** <br/>
    1. Application should be up and running<br/>
*  **Test data:** blank
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter<br/>
    2. Search Username search box should be kept as blank<br/>
    3. Click ‘Go’
*  **Expected Result :** <br/>
    1. ‘Github user not found’ message should be displayed<br/>
    2. Get Github webservice API should return 404 response code
    3. ‘No repos’ should be displayed as repo list header<br/>
    4. No repo links should be displayed

#### Test Scenario 4: Search result with invalid username
###### Test case 1: Check whether the search result with invalid username returns error
*  **Test case id :** TC_UI_HP_S04_N01
*  **User Story id :**  N/A
*  **Description :** Check whether the search result with invalid username returns error
*  **Automated :** No
*  **Priority :** Medium
*  **Prerequisite :** <br/>
    1. Application should be up and running<br/>
*  **Test data:** e.g. $”§$&/&((()/(&//&
*  **Steps to be executed :** <br/>
    1. Enter the URL in the browser and click enter<br/>
    2. Enter the text in the Search Username search box<br/>
    3. Click ‘Go’
*  **Expected Result :** <br/>
    1. ‘Something went wrong’ message should be displayed<br/>
    2. Get Github webservice API should return 400 response code
    3. ‘No repos’ should be displayed as repo list header<br/>
    4. No repo links should be displayed
    
## Test case prioritization
Test case are prioritized into,<br/>
    1. High<br/>
    2. Medium<br/>
    3. Low
    
### Reasoning for the test case prioritization
*   **High:**
    1. These test cases should be tested firstly
    2. These are the test case that represents the core functionality of the application
    3. These test cases are either business critical or most used business case
    4. Cannot release without this functionality
    5. These test case might communicate with backend or other applications to get or feed the data
    
*   **Medium:**
    1. These test cases should be tested after the high prioritized test cases
    2. These are mostly the UI test cases which validates the UI fields
    3. These test cases mostly involves in testing the input boxes with different data, select fields, buttons etc.
    4. Need these test cases for the release
    5. These are test cases of medium business critical and less used functionalities
    6. These are the test case which involving in the edge case testing
    
*   **Low:**
    1. These test case should be tested as least priority
    2. There are nice to have test cases
    3. There are mostly the UI validation of look and feel like color, position, label font and sizes, headers etc.,
    4. There the less critical and less used functionality test cases
        
