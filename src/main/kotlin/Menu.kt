import java.util.*

/*Утилитарный класс с одной фунцией для создания меню приложения*/
class Menu {
    val scanner = Scanner(System.`in`)
    fun getAMenu(arcList: MutableList<NewArchive>, screen: Screen) {
        while (true) {
            println("       0. Создать новый архив\n       1. Выбрать арихв\n       2. Завершить работу")
            print("Введите команду в формате \'цифра\': ")

            if (scanner.hasNextInt()) {
                val menuInput = scanner.nextInt()
                when (menuInput) {
                    0 -> arcList.add(screen.createAnArc())
                    1 -> {
                        if (arcList.isNotEmpty()) {
                            val recieved = screen.chooseAnArc(arcList)
                            if (recieved != null) {
                                println("Вы выбрали архив ${recieved.name}")
                                while (true) {
                                    println("       0. Создать новую заметку\n       1. Выбрать заметку \n       2. Вернуться")
                                    print("Введите команду в формате\'цифра\': ")
                                    if (scanner.hasNextInt()) {
                                        when (scanner.nextInt()) {
                                            0 -> screen.createANote(recieved)
                                            1 -> screen.chooseANote(recieved)
                                            2 -> break
                                            else -> println("Неверая команда, попробуйте еще раз")
                                        }

                                    } else {
                                        println("Ошибка ввода, попробуйте ввести цифру. ")
                                    }
                                    scanner.nextLine()
                                }
                            } else println("Нет каталога с таким названием!")
                        } else println("Здесь пока пусто. Создайте новый архив.")
                    }

                    2 -> return
                    else -> println("Неверая команда, попробуйте еще раз")
                }
            } else {
                println("Ошибка ввода, попробуйте ввести цифру: ")
            }
            scanner.nextLine()
        }
    }
}