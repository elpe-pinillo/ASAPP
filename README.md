# ASAPP
Android Shell Application
This application emulates a Linux Terminal. 
With it, you will be able to execute any Linux command supported by the android device. 
Please, enjoy. 

# Summary
* [Obfuscating](#Obfuscating)

* [Shell application](#Shell)
    * [Execution](#Execution)
    * [Decompiling](#Decompiling) 
    
* [Shell Application Obfuscated](#Shell-Obfuscated)
    * [Execution](#Execution-Obfuscated)
    * [Decompiling](#Decompiling-Obfuscated)     


# Obfuscating
The purpose of this repository is to demonstrate a simple guide to obfuscate one application and the key differences between the obfuscated app and a normal app when it comes to decompiling and analysing the apps. 

# Shell application
## Execution
The application provides a text box where you can type any command and run it. The results are printed. 

![Application Running](https://raw.githubusercontent.com/p3pinill0/ASAPP/main/Pictures/app_running.png)

If there is any problem another window will be prompted. 

## Decompiling
You can use different tools to decompile the code. In my case, I used APKTOOL to get the smali files. The code can be seen and it is easy to analyze what the apk does: 

![Application Decompiled](https://raw.githubusercontent.com/p3pinill0/ASAPP/main/Pictures/decompile_apk.png)

# Shell-Obfuscated
## Execution-Obfuscated
The obfuscation process does not change the functionality of the application, therefore, its execution is exactly the same. 

![Application Running](https://raw.githubusercontent.com/p3pinill0/ASAPP/main/Pictures/app_running.png)

## Decompiling-Obfuscated
The file names and variables have been modified. Now it is much harder to analyze the code:

![Application Obfuscated Decompiled](https://raw.githubusercontent.com/p3pinill0/ASAPP/main/Pictures/decompile_obfuscated_apk.png)

This is a simple way to obfuscate the apks. Check the following links for more information:

* https://www.solidict.com/blog/posts/android-minifyenabled-obfuscation-and-shrink.html
* https://oguzhanalpayli.medium.com/obfuscation-parcelable-and-serializable-for-navigation-component-59511d544fbd
* https://medium.com/rahasak/reverse-engineering-obfuscated-android-apk-67da84b259e4
