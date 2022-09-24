# Project-2 "Grocery"

This android application can make a list of items with their Price & Quantity.

# Build Plartfrom

Android Studio Dolphin | 2021.3.1 for Windows 64-bit

# Target SDK

Minimum SDK: 21, Target SDK: 33

# Package Name

com.soumitra.grocery

# Grocery Application

There are many pre-existing grocery list apps, but all of them don’t get worthy organic traffic due to the complicated user-interface. A broad age group operates such apps; therefore the user interface must be very preliminary and basic. Such apps are downloaded by the user for convenience, so we must not add too many security layers, as we know that security comes at the cost of convenience.

In this project, we are using MVVM (Model View ViewModel) for architectural patterns, Room for database, Coroutines and RecyclerView to display the list of items. Before jumping to the project let’s understand these terms.


## MVVM (Model View ViewModel)

MVVM architecture in android is used to give structure to the project’s code and understand code easily. MVVM is an architectural design pattern in android. MVVM treat Activity classes and XML files as View. This design pattern completely separate UI from its logic. Here is an image to quickly understand MVVM.  


# ROOM DataBase

Room persistence library is a database management library and it is used to store the data of apps like grocery item name, grocery item quantity, and grocery item price. Room is a cover layer on SQLite which helps to perform the operation on the database easily.

# RecycleView

RecyclerView is a container and it is used to display the collection of data in a large amount of data set that can be scrolled very effectively by maintaining a limited number of views.


# Coroutines

Coroutines are a lightweight thread, we use a coroutine to perform an operation on other threads, by this our main thread doesn’t block and our app doesn’t crash.

<details>
     <summary> Screenshorts </summary>
  
   Starting Screen         | Adding to list           |  Grocery list preview |  Delete Items
:-------------------------:|:-------------------------:|:-------------------------:|:-------------------------:
![](https://user-images.githubusercontent.com/90763881/192113706-3d4f691a-5413-47a8-8da4-9de571b9f3c9.jpg)|![](https://user-images.githubusercontent.com/90763881/192113755-42a0b5f3-b9c7-46e6-bc4d-de90d5d7a9c3.jpg))|![](https://user-images.githubusercontent.com/90763881/192113778-b129b801-978b-4519-b62a-002fc3cdbe7f.jpg)|![](https://user-images.githubusercontent.com/90763881/192113817-08587d8c-cb9d-4f17-a7b7-239bb76401d6.jpg)|
  
</details>
