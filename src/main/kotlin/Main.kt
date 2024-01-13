fun main() {
    //хранилище архивов
    val arcList: MutableList<NewArchive> = mutableListOf()

    //экземпляры утилитарных классов
    val screen = Screen()
    val menu = Menu()


    //Вход в программу
    menu.getAMenu(arcList, screen)

}