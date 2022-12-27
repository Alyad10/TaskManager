package com.example.taskmanager.ui.home
import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.taskmanager.App
import com.example.taskmanager.R
import com.example.taskmanager.databinding.FragmentHomeBinding
import com.example.taskmanager.ui.home.adapter.TaskAdapter
import com.example.taskmanager.ui.model.Task

class HomeFragment : Fragment(), TaskAdapter.Listener {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: TaskAdapter
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.recyclerView.adapter = adapter
        val data = App.db.dao().getAll()
        adapter.addTasks(data)
        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.taskFragment)

        }



    }

    override fun onClick(task: Task) {
        findNavController().navigate(R.id.taskFragment, bundleOf(KEY_FOR_TASK to task))
    }


        private fun showAlert(task: Task) {
        AlertDialog.Builder(context).setTitle("Are you want to delete ${task.title}?")
            .setMessage("Are you sure you want to delete it?")
            .setNegativeButton("NO") { dialog, which ->

            }.setPositiveButton("YES") { dialog, which ->
                App.db.dao().delete(task)
                adapter.onTaskDelete(task)
            }

            .show()
    }
    companion object{
        const val KEY_FOR_TASK ="task"
    }


    override fun onTaskDeleteClickListener(task: Task, position: Int) {
        showAlert(task)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}