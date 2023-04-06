package uz.itschool.lessonnavigation.TouchHelper

interface ItemTouchHelper {
    fun onItemMove(fromPosition: Int, toPosition: Int)
    fun onItemDismiss(position: Int)
}