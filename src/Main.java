import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Привет, у меня есть две игры для тебя 1)камешки 2)угадай число");
        int rej = sc.nextInt();
        switch (rej) {
            case 1:
                Stones();
                break;
            case 2:
                GuessNumber();
                break;
            default:
                System.out.println("Вы ввели что-то не то");
        }
    }

    public static void Stones() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Хорошо, Вы будете тырить камни с пляжа.");
        System.out.println("Условия игры: перед вами N камней на пляже, вы можете убрать 1 2 3 камня,проиграет тот, кто заберёт последний камень");
        Random random = new Random();
        System.out.println("Выберите сложность игры: 1) лёгкая 2) средняя 3) тяжёлая");
        int cloj = sc.nextInt();
        int stones = 0;
        switch (cloj) {
            case 1:
                stones = random.nextInt(17, 25);
                break;
            case 2:
                stones = random.nextInt(25, 35);
                break;
            case 3:
                System.out.print("Введите до скольки камней генерировать на пляже 35-");
                stones = random.nextInt(35, sc.nextInt());
                break;
            default:
                System.out.println("Вы ввели что-то не то");
        }
        int copstones = stones, i = 0;
        while (copstones != 0) {
            if (i % 2 == 0) {
                System.out.println("Сколько камней хотите взять? Всего " + copstones);
                int vzal = sc.nextInt();
                if (vzal > 3 || vzal < 0) System.out.println("Вы взяли камней больше, чем возможно");
                else if (copstones - vzal < 0) {
                    System.out.println("Столько камней нет!!!");
                } else {
                    copstones -= vzal;
                    if (vzal == 1) System.out.println("Вы взяли 1 камень. Осталось " + copstones + " камней.");
                    else if (vzal == 2) System.out.println("Вы взяли 2 камня. Осталось " + copstones + " камней.");
                    else System.out.println("Вы взяли 3 камня. Осталось " + copstones + " камней.");
                    i++;
                }
            } else {
                if (copstones % 4 == 0) {
                    copstones -= 3;
                    System.out.println("Компуктер взял 3 камня осталось " + copstones);
                } else if (copstones % 4 == 1) {
                    int vozm = random.nextInt(1, 3);
                    while (copstones - vozm < 0) vozm = random.nextInt(1, 3);
                    copstones -= vozm;
                    System.out.println("Компуктер взял " + vozm + " осталось " + copstones);
                } else if (copstones % 4 == 2) {
                    copstones -= 1;
                    System.out.println("Компуткер взял 1 камень осталось " + copstones);
                } else {
                    copstones -= 2;
                    System.out.println("Компуктер взял 2 камня осталось " + copstones);
                }
                i++;
            }

        }
        if (i % 2 == 1) System.out.println("Вы проиграли, будете играть ещё? 1 - да 2 - нет 3 - давай гадать теперь");
        else System.out.println("Вы выиграли, будете играть ещё?");
        System.out.println("Будете играть ещё?");
        int again = sc.nextInt();
        if (again == 1) Stones();
        else if (again == 2) System.out.println("Тогда до скорой встречи!");
        else GuessNumber();
    }

    public static void GuessNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Хорошо, Вы решили испытать удачу");
        System.out.print("Введите диапозон, в котором хотите угадывать 1-");
        Random random = new Random();
        int diap = sc.nextInt(), x = random.nextInt(1, diap), think, popi = 0;
        System.out.println(x);
        System.out.print("Сгенерировал число от 1 до " + diap + " Попробуйте угадать: ");
        think = sc.nextInt();
        while (think != x) {
            if (x > think) System.out.println("Загаданное число больше");
            else System.out.println("Загаданное число меньше");
            think = sc.nextInt();
            popi++;
        }
        System.out.println("Отлично, Вы потратили " + popi + " попыток. Будете играть опять? 1 - да 2 - нет 3 - давай в камушки");
        int again = sc.nextInt();
        if (again == 1) GuessNumber();
        else if (again == 2) System.out.println("Тогда до скорых встреч!");
        else Stones();
    }
}