package org.kechis.brewfest.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import org.kechis.brewfest.R
import org.kechis.brewfest.data.BrewRepository
import org.kechis.brewfest.data.PunkDataSource
import org.kechis.brewfest.data.interfaces.PunkApi
import org.kechis.brewfest.databinding.ActivityMainBinding
import org.kechis.brewfest.utils.Handlers
import org.kechis.brewfest.utils.addOnPropertyChanged
import org.kechis.brewfest.viewmodel.BrewsViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val BASE_URL = "https://api.punkapi.com/v2/"

class MainActivity : AppCompatActivity(), Handlers {


    private lateinit var mBrewsViewModel: BrewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mBrewsViewModel = createViewModel()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main)
        binding.handlers = this
        binding.bvm = mBrewsViewModel
        val layoutManager = LinearLayoutManager(this)
        binding.brewList.layoutManager = layoutManager


        val mBrewAdapter = BrewAdapter(mBrewsViewModel.brews, this)
        binding.brewList.adapter = mBrewAdapter

        binding.toolbar.setTitle(getString(R.string.app_name))
        setSupportActionBar(binding.toolbar)
        //Adding listener for checkbox change value
        mBrewsViewModel.vikingMode.addOnPropertyChanged {
            mBrewsViewModel.setBrews()
            mBrewAdapter.notifyDataSetChanged()
        }

        binding.queryFAB.setOnClickListener {

        }

        mBrewsViewModel.loadingVisibility.set(true)
        binding.executePendingBindings()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        menuInflater.inflate(R.menu.menu_main, menu)

        val checkBox = menu.findItem(R.id.action_checkbox).actionView as CheckBox
        checkBox.text = getText(R.string.strong)
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            mBrewsViewModel.vikingMode.set(isChecked)
        }

        return true
    }

    private fun createViewModel(): BrewsViewModel {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val punkDataSource = PunkDataSource(retrofit.create(PunkApi::class.java))
        val repository = BrewRepository(punkDataSource)
        return BrewsViewModel(repository, applicationContext)
    }


    override fun onClick(view: View) {
        Log.i(this::class.java.getSimpleName(), "Tapped")
        val layoutInflater = LayoutInflater.from(this@MainActivity)
        val root = findViewById<ViewGroup>(R.id.container)
        val promptView = layoutInflater.inflate(R.layout.dialog, root, false)
        val alertDialogBuilder = AlertDialog.Builder(this@MainActivity)
        alertDialogBuilder.setView(promptView)

        val editText = promptView.findViewById(R.id.food) as EditText

        alertDialogBuilder.setCancelable(false)
            .setPositiveButton(
                "OK"
            ) { _, _ ->
                mBrewsViewModel.brews.clear()
                mBrewsViewModel.getFoods(editText.text.toString())
            }
            .setNegativeButton(
                "Cancel"
            ) { dialog, _ -> dialog.cancel() }


        // create an alert dialog
        val alert = alertDialogBuilder.create()
        //Adding animation
        alert.window?.attributes?.windowAnimations = R.style.PauseDialogAnimation
        alert.show()
        editText.requestFocus()
    }
}
