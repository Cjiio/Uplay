package com.ulianla.uplay.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatDelegate
import com.ulianla.uplay.Config

class NightModeUtils {
    /**
     * 获取夜间模式
     * @param context Context
     * @return Int
     */
    fun getNightModel(context: Context): Int {
        val sp: SharedPreferences = context.getSharedPreferences(Config.SETTINGS_SP, Context.MODE_PRIVATE)
        return sp.getInt(Config.SETTINGS_SP, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }
    /**
     * 设置夜间模式
     * @param context Context
     * @param nightModel Int
     */
    fun setNightModel(context: Context, nightModel: Int) {
        val sp: SharedPreferences =
            context.getSharedPreferences(Config.SETTINGS_SP, Context.MODE_PRIVATE)
        sp.edit().putInt(Config.SETTINGS_SP, nightModel).apply()
    }
    /**
     * 初始化主题模式
     * @param context Context
     */
    fun initThemeMode(context: Context) {
        AppCompatDelegate.setDefaultNightMode(getNightModel(context))
    }
    /**
     * 应用夜间模式
     * @param context Context
     */
    fun applyNightModel(context: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        setNightModel(context, AppCompatDelegate.MODE_NIGHT_YES)
    }
    /**
     * 应用日间模式
     * @param context Context
     */
    fun applyDayModel(context: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setNightModel(context, AppCompatDelegate.MODE_NIGHT_NO)
    }
    /**
     * 应用跟随系统模式
     * @param context Context
     */
    fun applyFollowSystemModel(context: Context) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
        setNightModel(context, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)
    }
    /**
     * 判断App当前是否处于暗黑模式状态
     * @param context Context
     */
    fun isNightMode(context: Context): Boolean {
        val nightModel = getNightModel(context)
        return if (nightModel == AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM) {
            val applicationUiMode = context.resources.configuration.uiMode
            val systemMode = applicationUiMode and Configuration.UI_MODE_NIGHT_MASK
            systemMode == Configuration.UI_MODE_NIGHT_YES
        } else {
            nightModel == AppCompatDelegate.MODE_NIGHT_YES
        }
    }
}