# Adding a new option in the bottom navigation bar

In order to add a new option in the bottom navigation bar, follow these steps:

1. Go to app > res > navigation > mobile_navigation.xml
2. Add a new fragment tag (follow the examples of the other options)
3. Go to app > java > com.educationalappsdev.buho > MainActivity.kt
4. In line 23 add the id of the new option (follow the examples of the other options)
5. Go to app > java > com.educationalappsdev.buho > ui
6. Create a folder for the new option
7. Inside the new folder create two files: OptionFragment.kt and OptionViewModel.kt (follow the examples of the other options)
8. Go to app > res
9. Right click on drawable > New > Vector Asset
10. Select an icon for the new option > click on Next > click on Finish
11. Go to app > res > menu > bottom_nav_menu.xml
12. Add a new item tag (follow the examples of the other options)