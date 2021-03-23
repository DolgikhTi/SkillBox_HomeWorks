package ru.skillbox;

public class Elevator
    {
        private int currentFloor = 1;
        private int minFloor = -3;
        private int maxFloor = 26;

        public Elevator(int minFloor, int maxFloor)
        {
            this.minFloor = minFloor;
            this.maxFloor = maxFloor;
        }

        public int getCurrentFloor()
        {
            return currentFloor;
        }

        public void moveDown()
        {
            currentFloor = currentFloor >= minFloor ? currentFloor - 1 : currentFloor;
        }

        public void moveUP()
        {
            currentFloor = currentFloor <= maxFloor ? currentFloor + 1 : currentFloor;
        }

        public void move(int floor)
        {
            if (floor < minFloor & floor > maxFloor)
            {
                System.out.println("ошибка");
            }

            else if (floor > currentFloor)
            {
                for (currentFloor = currentFloor + 1; currentFloor <= floor; currentFloor = currentFloor + 1)
                {
                    System.out.println("Текущий этаж: " + currentFloor);
                }
            }

            else if (floor < currentFloor)
            {
                for (currentFloor = currentFloor - 1; currentFloor >= floor; currentFloor = currentFloor - 1)
                {
                    System.out.println("Текущий этаж: " + currentFloor);
                }
            }
        }
    }
