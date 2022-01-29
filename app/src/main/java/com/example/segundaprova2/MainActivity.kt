package com.example.segundaprova2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonHome: Button
    private lateinit var buttonCadastro: Button
    private lateinit var buttonAltera: Button

    private lateinit var homeFragment: HomeFragment
    private lateinit var alteraFragment: AlteraFragment
    private lateinit var cadastraFragment: CadastraFragment
    //private lateinit var sobreFragment: SobreFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val db: AppDatabase by lazy {
            Room.databaseBuilder(
                this,
                AppDatabase::class.java, "database-name")
                .allowMainThreadQueries()
                .build()
        }




        db.userDao().inserir(Usuariodb("nome", "sobrenome", "naturalidade", "profissao", 20))
        db.userDao().listAll().forEach { Log.i("APPROOM", it.toString()) }

        */

        //inicializando nossos componentes

        buttonHome = findViewById(R.id.button_home)
        buttonHome.setOnClickListener(this)
        buttonCadastro = findViewById(R.id.button_cadastra)
        buttonCadastro.setOnClickListener(this)
        buttonAltera = findViewById(R.id.button_altera)
        buttonAltera.setOnClickListener(this)

        //instanciando os fragments

        homeFragment = HomeFragment()
        alteraFragment = AlteraFragment()
        cadastraFragment = CadastraFragment()

        setFragment(homeFragment)

    }

    //Metodo responsavel pela troca dos fragmentos
    private fun setFragment(fragment: Fragment){
        val fragmentTransicao = supportFragmentManager.beginTransaction()
        fragmentTransicao.replace(R.id.fragments, fragment)
        fragmentTransicao.commit()
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.button_home -> {
                setFragment(homeFragment)
            }
            R.id.button_altera -> {
                setFragment(alteraFragment)
            }
            R.id.button_cadastra -> {
                setFragment(cadastraFragment)
            }
        }
    }
}