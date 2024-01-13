import java.util.*

/*Класс с фунциями для создания меню и подменю приложения*/
class Menu {
    private val scanner = Scanner(System.`in`)

    // Функция для создания основного меню для работы с архивами
    fun getAMenu(arcList: MutableList<NewArchive>, screen: Screen) {
        while (true) {
            println("       0. Создать новый архив\n       1. Выбрать арихв\n       2. Завершить работу")
            print("Введите команду в формате \'цифра\': ")

            if (scanner.hasNextInt()) {
                when (scanner.nextInt()) {
                    0 -> arcList.add(screen.createAnArc())
                    1 -> {
                        if (arcList.isNotEmpty()) {
                            val recieved = screen.chooseAnArc(arcList)
                            println("Вы выбрали архив ${recieved.name}")
                            getASecondMenu(recieved, screen)
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

    // Функция для работы со вторичным меню заметок
    private fun getASecondMenu(archive: NewArchive, screen: Screen){
        while (true) {
            println("       0. Создать новую заметку\n       1. Выбрать заметку \n       2. Вернуться")
            print("Введите команду в формате\'цифра\': ")
            if (scanner.hasNextInt()) {
                when (scanner.nextInt()) {
                    0 -> screen.createANote(archive)
                    1 -> screen.chooseANote(archive)
                    2 -> break
                    else -> println("Неверая команда, попробуйте еще раз")
                }

            } else {
                println("Ошибка ввода, попробуйте ввести цифру. ")
            }
            scanner.nextLine()
        }
    }
}