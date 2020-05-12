package com.tr4n.todoapp.data.source.local.base

interface OnDataLoadedCallback<T> {
    fun onSuccess(data: T)
    fun onFailure(exception: Exception = Exception())
}
