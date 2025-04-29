package com.tworoot2.privacyinspector.presentation.states.application_state

import android.graphics.drawable.Drawable


data class AllApplicationsState(
    val apps: List<AppPermissionInfo> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)

data class AppPermissionInfo(
    val appName: String,
    val packageName: String,
    val icon: Drawable, // You need Context to get this
    val grantedPermissions: List<String>
)
