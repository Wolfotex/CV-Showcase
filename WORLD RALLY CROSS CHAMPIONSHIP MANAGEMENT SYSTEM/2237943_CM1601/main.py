import functions  # import the function in the functions file
import time

functions.files()  # Call out the Files Function

racers = functions.racers
races = functions.races

# main program
while True:
    functions.menu()  # Display the menu.
    user_input = input("Please type your option: ")  # To Get The User Input
    print("")

    if user_input == "ADD":  # Add Racer Details
        functions.aaa()  # Calling The Function To Add The Details
        print("\nType R to return to the main menu.\nType ESC to exit the program.")  # To Stop The Infinite While Loop
        auth = input("Enter your option: ")
        if auth == "R":  # try to repeat this
            pass
        else:
            print("exiting the program.")
            break
    elif user_input == "DDD":  # Delete Racer Details
        functions.ddd()  # Calling The Function To Delete A Racer

    elif user_input == "UDD":  # Update Racer Details
        functions.udd()  # Calling The Function
        print("\nType R to return to the main menu.\nType ESC to exit the program.")
        auth = input("Enter your option: ")
        if auth == "R":
            pass
        else:
            print("exiting the program.")
            break

    elif user_input == "VCT":  # View Standings Table
        functions.vct()  # Calling The Function
        print("\nType R to return to the main menu.\nType ESC to exit the program.")
        auth = input("Enter your option: ")
        if auth == "R":
            pass
        else:
            print("exiting the program.")
            break
    elif user_input == "SRR":  # Simulate A Random Race
        functions.srr()  # Calling The Function
        print("\nType R to return to the main menu.\nType ESC to exit the program.")
        auth = input("Enter your option: ")
        if auth == "R":
            pass
        else:
            print("exiting the program.")
            break
    elif user_input == "VRL":  # View Race Table Sorted According To The Date
        functions.vrl()  # Calling The Function
        print("\nType R to return to the main menu.\nType ESC to exit the program.")
        auth = input("Enter your option: ")
        if auth == "R":
            pass
        else:
            print("exiting the program.")
            break
    elif user_input == "STF":  # Save Current Data To A Text File
        functions.stf()  # Calling The Function
        print("\nType R to return to the main menu.\nType ESC to exit the program.")
        auth = input("Enter your option: ")
        if auth == "R":
            pass
        else:
            print("existing the program.")
            break
    elif user_input == "RFF":  # Load Dataa From The Saved Text FIle
        functions.rff()  # Calling The Function
        print("\nType R to return to the main menu.\nType ESC to exit the program.")
        auth = input("Enter your option: ")
        if auth == "R":
            pass
        else:
            print("exiting the program.")
            break
    elif user_input == "ESC":  # Exit the program
        print("\nexiting the program.")
        break

    else:
        print("\nInvalid option. Please check your spelling and try again.")  # When The Input Is Invalid.
        time.sleep(2)
