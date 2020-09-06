package ru.alexleru.brickseasy

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.vk.api.sdk.VK
import com.vk.api.sdk.VKApiCallback
import com.vk.api.sdk.auth.VKAccessToken
import com.vk.api.sdk.auth.VKAuthCallback
import ru.alexleru.brickseasy.databinding.ActivityMainBinding
import ru.alexleru.brickseasy.models.VKUser
import ru.alexleru.brickseasy.requests.VKUsersRequest


class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        APP_ACTIVITY = this
    }

    fun vkLogin() {
        if (!VK.isLoggedIn()) {
            VK.login(this)
        } else {
            toSuccessFragment()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        val callback = object : VKAuthCallback {
            override fun onLogin(token: VKAccessToken) {
                getDataUserVK()
            }

            override fun onLoginFailed(errorCode: Int) {
                ErrorDialogFragment().show(supportFragmentManager, "check")
            }
        }

        if (data == null || !VK.onActivityResult(requestCode, resultCode, data, callback)) {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    fun getDataUserVK() {
        VK.execute(VKUsersRequest(), object : VKApiCallback<List<VKUser>> {
            override fun success(result: List<VKUser>) {
                val user = result[0]
                APP_Name = user.firstName

                toSuccessFragment()
            }
            override fun fail(error: Exception) {
                ErrorDialogFragment().show(supportFragmentManager, "check")
            }
        })
    }

    fun toSuccessFragment() {
        Navigation.findNavController(APP_ACTIVITY, R.id.fragment_host)
            .navigate(R.id.action_logginFragment_to_successFragment)
    }

}