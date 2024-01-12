import java.util.*

/*
Основной утилитарный класс для создания элементов приложения
*/
class Screen {
    //Функция для создания архива
    fun createAnArc(): NewArchive {
        println("Введите наименование архива: ")
        return NewArchive(Scanner(System.`in`).nextLine().toString(), mutableSetOf())
    }

    // Функция  для выбора архива из хранилища архивов
    fun chooseAnArc(mutableList: MutableList<NewArchive>): NewArchive? {

        println("Ваши архивы: ")
        mutableList.forEach { println(it.name) }
        while (true) {
            println("Для выбора архива введите его имя: ")
            val inputName = Scanner(System.`in`).nextLine().toString()
            var element: NewArchive? = null
            for (el in mutableList) {
                if (inputName.equals(el.name)) {
                    element = el
                    break
                }
            }
            return element
        }
    }

    //Функция для создания заметки в архиве
    fun createANote(archive: NewArchive) {
        println("Введите наименование заметки: ")
        val noteName = Scanner(System.`in`).nextLine().toString()
        println("Теперь введите текст, то есть тело заметки")
        val text = Scanner(System.`in`).nextLine()

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
                println("${el.name} ")
            }
            println("Для просмотра текста заметки введите его имя: ")
            val inputName = Scanner(System.`in`).nextLine().toString()
            for (el in archive.mutableSet) {
                if (el.name.equals(inputName)) {
                    println(el.text)
                    return
                } else continue
            }
            println("Заметка с таким именем не найдена")
        }
    }

}

// классы хранилища для архивов и заметок
data class NewArchive(val name: String, var mutableSet: MutableSet<NewNote>)
data class NewNote(val name: String, var text: String)