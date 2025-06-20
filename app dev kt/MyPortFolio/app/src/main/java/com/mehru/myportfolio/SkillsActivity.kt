package com.mehru.myportfolio

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.mehru.myportfolio.databinding.ActivitySkillBinding

class AddSkillsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySkillBinding
    private val skillList = mutableListOf<String>()
    private lateinit var skillAdapter: SkillAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySkillBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)


        skillAdapter = SkillAdapter(skillList)
        binding.recyclerViewSkills.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewSkills.adapter = skillAdapter

        binding.fabAddSkill.setOnClickListener {
            val intent = Intent(this, AddSkillActivity::class.java)
            startActivityForResult(intent, 1001)
        }

    }
}