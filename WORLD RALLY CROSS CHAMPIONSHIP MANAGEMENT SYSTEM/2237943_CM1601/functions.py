import time # to add a delay
import random # to genrate random numbers and randomize elements of a list
# Create Variables For The Temp List
racers = []
races = []

# Defining functions
def files():  # Create Files
    try:
        with open("Data/Racer.txt", "r") as Racer:  # To Avoid File Rewriting, Check For The Existing File First.
            pass
    except:
        with open("Data/Racer.txt", "w") as Racer:  # Text File For The Racer Details
            pass
    try:
        with open("Data/Races.txt", "r") as Races:  # Text File For The Races
            pass
    except:
        with open("Data/Races.txt", "w") as Races:
            pass

def menu():  # Add menu
    print("\n",
          "-" * 10 + "WORLD RALLY CROSS CHAMPIONSHIP MANAGEMENT SYSTEM" + "-" * 10,  # Header
          "\n")
    menu_t = "**Menu**"  # menu_t= menu title
    menu_t = menu_t.center(60)
    print(menu_t)
    print("\n"
          "Type ADD for adding driver details\n"
          "Type DDD for deleting\n"
          "Type UDD for updating driver details\n"
          "Type VCT for viewing the rally cross standings table\n"
          "Type SRR for simulating a random race\n"
          "Type VRL for viewing race table sorted according to the date\n"
          "Type STF to save the current data to a text file\n"
          "Type RFF to load data from the saved text file\n"
          "Type ESC to exit the program"
          "\n")
    print("-" * 68)

def aaa():  # Add Racer Details
    add_t = "**Add Racer Details**"  # Add title
    add_t = add_t.center(60)
    print(add_t)
    while True:
        print("\nPlease enter the following Racer details,")  # To Get The Racer's Details
        fName = input("Racer's First Name: ")
        sName = input("Racer's Second name: ")
        rName = fName + "_" + sName  # To Combine The Given Name So It Is Easier To Check For Duplicated Files (Racer Name)
        rAge = input("Racer's Age: ")
        rCar = input("Racer's Car: ")
        rTeam = input("Racer's Team: ")
        rPoints = input("Racer's Current Points: ")
        print(
            "Are above details correct?\n Y-Yes, they are correct.\n N- No, I need to change it.\n")  # Detail Confirmation
        rVerify = input("Type your option: ")
        if rVerify == "Y":
            break
        elif rVerify == "N":
            continue
        else:
            print("\nInvalid option. Please try again")
            time.sleep(1.2)
    dData = False  # Check For Data Duplication (dData = duplication of Data)
    for r in racers:
        r = r.split("|")
        if rName == r[0]:
            dData = True
            break
        else:
            continue
    if not dData:  # Adding Racer To The List
        rTeam = "_".join(rTeam.split())
        rCar = "_".join(rCar.split())
        rData = rName + "|" + rAge + "|" + rCar + "|" + rTeam + "|" + rPoints
        racers.append(rData)
        print("Racer " + rName + " Successfully registered! Please save the racer details.")
    else:
        print("\nThe Racer Already Exists!")
        time.sleep(1.2)

def ddd():  # Delete Racer Details
    ddd_t = "**Delete Racer Details**"
    ddd_t = ddd_t.center(60)
    print(ddd_t)
    while True:
        print("\nType Y to continue to delete a user.\nType N to return to main menu.")
        confirm = input("Enter your option: ")
        if confirm == "Y":
            while True:
                print("\nPlease type the name of the racer you want to delete.")
                fName = input("Racer's First Name: ")
                sName = input("Racer's Second name: ")
                rName = fName + "_" + sName
                print("\nType Y to proceed.\nType N to edit racer's name")
                confirmD = input("Enter your choice: ")
                if confirmD == "Y":
                    for racer in racers:   # Find the given racer
                        racer = racer.split("|")
                        if rName in racer:
                            print("\nName: " + racer[0])
                            break
                        else:
                            continue
                    print("Are you sure you want to delete the above racer,\n"  # Detail Confirmation
                          "Y - Yes\n"
                          "N - No")
                    confirm2 = input("\nEnter your choice: ")

                    if confirm2 == "Y":
                        temp = []
                        for racer in racers: # Removing the seleceted racer from the list
                            updated_racer = racer.split("|")
                            if rName in updated_racer:
                                pass
                            else:
                                temp.append(racer)
                        racers.clear()
                        for i in temp:
                            racers.append(i)
                        print(rName, " Successfully deleted!")
                        break

                    elif confirm2 == "N":
                        break

                elif confirmD == "N":
                    continue
                else:
                    print("\nInvalid Option.Please try again.")
                    time.sleep(1.2)

        elif confirm == "N":
            break
        else:
            print("\ninvalid option. Try again.")
            time.sleep(1.2)

def udd():  # Update Racer Details
    udd_t = "**Update Racer Details**"  # The Header
    udd_t = udd_t.center(140)
    print(udd_t)
    print("-"*145)
    print(f"{'No.':<5}{'Name':<35}{'Age':<15}{'Car':<40}{'Team':<30}{'points':<20}")
    print("-" * 145)
    num = 0
    for r in racers:  # Display all the available racers
        num += 1
        r = r.split("|")
        print(f"{num:<5}{r[0]:<35}{r[1]:<15}{r[2]:<40}{r[3]:<30}{r[4]:<20}")
    print("-" * 145)
    while True:  # select a racer
        racerNo = int(input("\nEnter the number assigned to the racer you wish to update: "))
        if len(racers) < racerNo:
            print("Invalid option. Please try again.")
            time.sleep(1.2)
        else:
            break
    racerNo = racerNo - 1
    print("Selected Racer,") # Display selected driver
    racer = racers[racerNo].split("|")
    while True: # Ask for what record to update
        print("\nwhat record would you like to update,"
              "\nType N for Name"
              "\nType A for Age"
              "\nType C for Car"
              "\nType T for Team"
              "\nType P for Points")
        update_details = input("Type your choice: ")
        if update_details == "N": # update name
            update_fName = input("New first name: ")
            update_sName = input("New second name: ")
            updated_name = update_fName + "_" + update_sName
            racer[0] =updated_name
            break
        elif update_details == "A": # update age
            update_age = input("New age: ")
            racer[1] = update_age
            break
        elif  update_details == "C": # update car
            update_car = input("New car name: ")
            racer[2] = update_car
            break
        elif update_details == "T": # update team
            update_team = input("New team name: ")
            racer[3] = update_team
            break
        elif update_details == "P": # update points
            update_points = input("New points of the racer: ")
            racer[4] = update_points
            break
        else:
            print("Invalid option.Please try again.")
            time.sleep(1.2)
    num1 = 0
    updated_record = ""
    for data in racer: # updating the updated records of the racer in the racers list
        if num1 == 0:
            updated_record = updated_record + data
        else:
            updated_record = updated_record + "|" + data
        num1 += 1
    temp_list = []
    for r in racers:
        temp_list.append(r)
    racers.clear()
    for racer in temp_list:
        if updated_record.split("|")[0] == racer.split("|")[0]:
            racers.append(updated_record)
        else:
            racers.append(racer)
    print("Record successfully updated!")

def vct():  # View Standings Table
    vct_t = "**View Standings Table**"
    vct_t = vct_t.center(60)
    print(vct_t)
    data = []  # variables for the vct
    sorted_data = []
    for racer in racers:
        data.append(racer)
    while data:  # sorting racers by the amount of points
        max = data[0]
        for i in data:
            if int(i.split("|")[4]) > int(max.split("|")[4]):
                max = i
        sorted_data.append(max)
        data.remove(max)
    n=0
    print("-" * 145) # display sorted racers by points
    print(f"{'No.':<5}{'Name':<35}{'Age':<15}{'Car':<40}{'Team':<30}{'points':<20}")
    print("-" * 145)
    for racer in sorted_data:
        n += 1
        racer = racer.split("|")
        print(f"{n:<5}{racer[0]:<35}{racer[1]:<15}{racer[2]:<40}{racer[3]:<30}{racer[4]:<20}")
    print("-" * 145)

def srr():  # Simulate A Random Race
    locations = ["Nyirad", "Holjes", "Montalegre", "Barcelona", "Riga", "Norway"] # all the locations


    temp = [] # creating a temperory list
    for racer in racers:
        temp.append(racer)

    y = [2020, 2021, 2022, 2023] # generating a random date
    year = random.choice(y)
    month = random.randint(1, 12)
    if month == 2:
        day = random.randint(1, 28)

    elif month == 4 or month == 6 or month == 9 or month == 11:
        day = random.randint(1, 30)

    else:
        day = random.randint(1, 31)


    date = day,"/",month,"/",year # convert random date to str
    date = str(date)

    location = random.choice(locations) # select a random location
    random.shuffle(temp) # randomize racers order to give a position

    tempData = []
    for driver in temp: # giving points according to the position of racers
        driver = driver.split("|")
        points = int(driver[4])
        if temp[0].split("|")[0] == driver[0]: # 1st place
            points = points + 10
            driver[4] = points
            driver = driver[0] + "|" + driver[1] + "|" + driver[2] + "|" + driver[3] + "|" + str(driver[4])
            tempData.append(driver)

        elif temp[1].split("|")[0] == driver[0]: # 2nd place
            points = points + 7
            driver[4] = points
            driver = driver[0] + "|" + driver[1] + "|" + driver[2] + "|" + driver[3] + "|" + str(driver[4])
            tempData.append(driver)

        elif temp[2].split("|")[0] == driver[0]: # 3rd place
            points = points + 5
            driver[4] = points
            driver = driver[0] + "|" + driver[1] + "|" + driver[2] + "|" + driver[3] + "|" + str(driver[4])
            tempData.append(driver)

        else:
            driver = driver[0] + "|" + driver[1] + "|" + driver[2] + "|" + driver[3] + "|" + str(driver[4])
            tempData.append(driver)
            continue

    racers.clear() # add updated stats to the racers list
    for racer in tempData:
        racers.append(racer)

    print("Location: " + location, # display race results
          "\nDate: " + date)
    print("Results,")

    n = 0
    print("-" * 135)
    print(f"{'Position':<15}{'Name':<15}{'Age':>27}{'Team':>30}{'Car':>30}{'Points':>32}")
    print("-" * 135)
    for driverD in tempData:
        driver = driverD.split("|")
        n = n + 1
        print(f"{n:<15}{driver[0]:<15}{driver[1]:>30}{driver[2]:>30}{driver[3]:>30}{driver[4]:>30}")
        if n == 1:
            race = location + "-" + date + "-" + driverD
        else:
            race = race + "-" + driverD
    races.append(race) # add race details to the races list

def vrl():  # View Race Table Sorted According To The Date
    vrl_t = "**view race table sorted according to the date**"
    vrl_t = vrl_t.center(80)
    print(vrl_t)
    print(races)

def stf():  # Save Current Data To A Text File
    stf_t = "**Saved Racer Details**"
    stf_t = stf_t.center(60)
    print(stf_t)
    with open("Data/Racer.txt","w") as Racer: # save racers data to racer text file
        for r in racers:
            Racer.write(r)
            Racer.write("\n")

    with open("Data/Races.txt","w") as Race: # save races data to races text file
        for r in races:
            Race.write(r)
            Race.write("\n")

def rff():  # Load Dataa From The Saved Text FIle
    rff_t = "**Load Racer Details**"
    rff_t = rff_t.center(60)
    print(rff_t)
    with open("Data/Racer.txt", "r") as Racer: # load all the racer data to racers list
            rData = Racer.read()
            rData = rData.split()
            for r in rData:
                racers.append(r)
    print("-" * 145)
    print(f"{'Name':<35}{'Age':<15}{'Car':<40}{'Team':<30}{'points':<20}")
    print("-" * 145)
    for r in racers: # display all the loaded drivers
        r = r.split("|")
        print(f"{r[0]:<35}{r[1]:<15}{r[2]:<40}{r[3]:<30}{r[4]:<20}")
    print("-" * 145)

    with open("Data/Races.txt", "r") as Racer: # load all race data to races list
            rData = Racer.read()
            rData = rData.split()
            for r in rData:
                races.append(r)