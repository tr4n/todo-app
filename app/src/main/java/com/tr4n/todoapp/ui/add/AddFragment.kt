package com.tr4n.todoapp.ui.add

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.tr4n.todoapp.R
import com.tr4n.todoapp.data.Task
import kotlinx.android.synthetic.main.fragment_add.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddFragment : Fragment(R.layout.fragment_add) {

    private val viewModel: AddViewModel by viewModel()

    var onPopBackstack: () -> Unit = {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenEvents()
        observeData()
    }

    private fun listenEvents() {
        frameAdd.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
            onPopBackstack()
        }
        textCancel.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
            onPopBackstack()
        }

        textCreate.setOnClickListener {
            val task = Task(
                title = editTitle.text?.toString() ?: "",
                description = editDescription?.text?.toString() ?: ""
            )
            viewModel.createTask(task)
        }
    }

    private fun observeData() {
        viewModel.error.observe(viewLifecycleOwner) { errorMsg ->
            context?.run {
                Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show()
            }
        }
        viewModel.isCreateSuccess.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                activity?.supportFragmentManager?.popBackStack()
                onPopBackstack()
            }
        }
    }
}
