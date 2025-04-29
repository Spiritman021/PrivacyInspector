package com.tworoot2.privacyinspector.presentation.viewmodel


import android.app.Application
import android.content.pm.PackageManager
import androidx.core.content.ContextCompat
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.tworoot2.privacyinspector.presentation.states.application_state.AllApplicationsState
import com.tworoot2.privacyinspector.presentation.states.application_state.AppPermissionInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class AllApplicationsViewModel(application: Application) : AndroidViewModel(application) {

    private val _state = MutableStateFlow(AllApplicationsState())
    val state = _state.asStateFlow()

    init {
        loadInstalledApps()
    }

    private fun loadInstalledApps() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.value = _state.value.copy(isLoading = true)

            try {
                val packageManager = getApplication<Application>().packageManager
                val packages = packageManager.getInstalledPackages(PackageManager.GET_PERMISSIONS)

                val apps = packages.mapNotNull { pkg ->
                    if (pkg.requestedPermissions == null) return@mapNotNull null
                    val appName = pkg.applicationInfo!!.loadLabel(packageManager).toString()
                    val icon = pkg.applicationInfo!!.loadIcon(packageManager)
                    val packageName = pkg.packageName

                    val permissions = pkg.requestedPermissions
                    val granted = permissions?.filter { permission ->
                        ContextCompat.checkSelfPermission(
                            getApplication(),
                            permission
                        ) == PackageManager.PERMISSION_GRANTED
                    } ?: emptyList()

                    val requested = permissions?.toList() ?: emptyList()


                    AppPermissionInfo(
                        appName = appName,
                        packageName = packageName,
                        icon = icon,
                        grantedPermissions = requested
                    )
                }.sortedBy { it.appName.lowercase() }

                _state.value = AllApplicationsState(apps = apps, isLoading = false)
            } catch (e: Exception) {
                _state.value = _state.value.copy(isLoading = false, error = e.message)
            }
        }
    }
}
