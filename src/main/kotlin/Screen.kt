import java.util.*

/*
Основной утилитарный класс для создания элементов приложения
*/
class Screen {
    private val scanner = Scanner(System.`in`)
    //Функция для создания архива
    fun createAnArc(): NewArchive {
        var input  = ""
        while (true) {
            println("Введите наименование архива: ")
            input = scanner.nextLine().toString()
            if (input.isNotBlank()) break
            else println("Ошибка ввода. Вы ввели пробел")
        }
        return NewArchive(input, mutableSetOf())
    }

    // Функция  для выбора архива из хранилища архивов
    fun chooseAnArc(list: List<NewArchive>): NewArchive {

        println("Ваши архивы: ")
        list.forEachIndexed { index, newArchive -> println("       $index. Архив: ${newArchive.name}") }
        while (true) {
            println("Для выбора архива введите его номер: ")
            if(scanner.hasNextInt()) {
                val inputNumber = scanner.nextInt()
                list.forEachIndexed{index, newArchive ->
                    if(index == inputNumber)return newArchive
                    else println("Нет архива под таким номером!")
                }
            }else {
                println("Ошибка ввода. Введите число")
                scanner.nextLine()
            }
        }
    }

    //Функция для создания заметки в архиве
    fun createANote(archive: NewArchive) {

            var noteName = ""
            var text = ""
        while (true) {
            println("Введите наименование заметки: ")
            noteName = Scanner(System.`in`).nextLine().toString()
            if(noteName.isNotBlank()) break
            else println("Ошибка ввода. Вы ввели пробел.")
        }
        while (true){
            println("Теперь введите текст, то есть тело заметки")
            text = Scanner(System.`in`).nextLine().toString()
            if(text.isNotBlank()) break
            else println("Ошибка ввода. Вы ввели пробел.")
        }
        println("Ваша заметка создана и добавленна к списку заметок.")
        archive.mutableSet.add(NewNote(noteName, text))
    }

    //Функция выбора заметки в архиве
    fun chooseANote(archive: NewArchive) {
        if (archive.mutableSet.isEmpty()) {
            println("Здесь пока пусто. Создайте новую заметку.")
            return
        } else {
            println("Список заметок: ")
            for (el in archive.mutableSet) {
                println("       Заметка: ${el.name} ")
            }
            println("Для просмотра текста заметки введите его имя: ")
            val inputName = Scanner(System.`in`).nextLine().toString()
                val found = archive.mutableSet.find{inputName == it.name}
                if(found != null) println(found.text)
                else println("Заметка с таким именем не найдена")
        }
    }

}

// классы хранилища для архивов и заметок
data class NewArchive(val name: String, val mutableSet: MutableSet<NewNote>)
data class NewNote(val name: String, val text: String)
