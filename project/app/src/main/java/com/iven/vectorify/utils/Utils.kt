package com.iven.vectorify.utils


import android.app.WallpaperManager
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.res.ColorStateList
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.graphics.drawable.RippleDrawable
import android.os.Build
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import androidx.core.net.toUri
import com.iven.vectorify.LiveWallpaper
import com.iven.vectorify.R
import com.iven.vectorify.vectorifyPreferences


object Utils {

    //https://material.io/resources/color/
    val colors = listOf(
        R.color.red_50,
        R.color.red_100,
        R.color.red_200,
        R.color.red_300,
        R.color.red_400,
        R.color.red_500,
        R.color.red_600,
        R.color.red_700,
        R.color.red_800,
        R.color.red_900,
        R.color.pink_50,
        R.color.pink_100,
        R.color.pink_200,
        R.color.pink_300,
        R.color.pink_400,
        R.color.pink_500,
        R.color.pink_600,
        R.color.pink_700,
        R.color.pink_800,
        R.color.pink_900,
        R.color.purple_50,
        R.color.purple_100,
        R.color.purple_200,
        R.color.purple_300,
        R.color.purple_400,
        R.color.purple_500,
        R.color.purple_600,
        R.color.purple_700,
        R.color.purple_800,
        R.color.purple_900,
        R.color.deep_purple_50,
        R.color.deep_purple_100,
        R.color.deep_purple_200,
        R.color.deep_purple_300,
        R.color.deep_purple_400,
        R.color.deep_purple_500,
        R.color.deep_purple_600,
        R.color.deep_purple_700,
        R.color.deep_purple_800,
        R.color.deep_purple_900,
        R.color.indigo_50,
        R.color.indigo_100,
        R.color.indigo_200,
        R.color.indigo_300,
        R.color.indigo_400,
        R.color.indigo_500,
        R.color.indigo_600,
        R.color.indigo_700,
        R.color.indigo_800,
        R.color.indigo_900,
        R.color.blue_50,
        R.color.blue_100,
        R.color.blue_200,
        R.color.blue_300,
        R.color.blue_400,
        R.color.blue_500,
        R.color.blue_600,
        R.color.blue_700,
        R.color.blue_800,
        R.color.blue_900,
        R.color.light_blue_50,
        R.color.light_blue_100,
        R.color.light_blue_200,
        R.color.light_blue_300,
        R.color.light_blue_400,
        R.color.light_blue_500,
        R.color.light_blue_600,
        R.color.light_blue_700,
        R.color.light_blue_800,
        R.color.light_blue_900,
        R.color.cyan_50,
        R.color.cyan_100,
        R.color.cyan_200,
        R.color.cyan_300,
        R.color.cyan_400,
        R.color.cyan_500,
        R.color.cyan_600,
        R.color.cyan_700,
        R.color.cyan_800,
        R.color.cyan_900,
        R.color.teal_50,
        R.color.teal_100,
        R.color.teal_200,
        R.color.teal_300,
        R.color.teal_400,
        R.color.teal_500,
        R.color.teal_600,
        R.color.teal_700,
        R.color.teal_800,
        R.color.teal_900,
        R.color.green_50,
        R.color.green_100,
        R.color.green_200,
        R.color.green_300,
        R.color.green_400,
        R.color.green_500,
        R.color.green_600,
        R.color.green_700,
        R.color.green_800,
        R.color.green_900,
        R.color.light_green_50,
        R.color.light_green_100,
        R.color.light_green_200,
        R.color.light_green_300,
        R.color.light_green_400,
        R.color.light_green_500,
        R.color.light_green_600,
        R.color.light_green_700,
        R.color.light_green_800,
        R.color.light_green_900,
        R.color.lime_50,
        R.color.lime_100,
        R.color.lime_200,
        R.color.lime_300,
        R.color.lime_400,
        R.color.lime_500,
        R.color.lime_600,
        R.color.lime_700,
        R.color.lime_800,
        R.color.lime_900,
        R.color.yellow_50,
        R.color.yellow_100,
        R.color.yellow_200,
        R.color.yellow_300,
        R.color.yellow_400,
        R.color.yellow_500,
        R.color.yellow_600,
        R.color.yellow_700,
        R.color.yellow_800,
        R.color.yellow_900,
        R.color.amber_50,
        R.color.amber_100,
        R.color.amber_200,
        R.color.amber_300,
        R.color.amber_400,
        R.color.amber_500,
        R.color.amber_600,
        R.color.amber_700,
        R.color.amber_800,
        R.color.amber_900,
        R.color.orange_50,
        R.color.orange_100,
        R.color.orange_200,
        R.color.orange_300,
        R.color.orange_400,
        R.color.orange_500,
        R.color.orange_600,
        R.color.orange_700,
        R.color.orange_800,
        R.color.orange_900,
        R.color.deep_orange_50,
        R.color.deep_orange_100,
        R.color.deep_orange_200,
        R.color.deep_orange_300,
        R.color.deep_orange_400,
        R.color.deep_orange_500,
        R.color.deep_orange_600,
        R.color.deep_orange_700,
        R.color.deep_orange_800,
        R.color.deep_orange_900,
        R.color.brown_50,
        R.color.brown_100,
        R.color.brown_200,
        R.color.brown_300,
        R.color.brown_400,
        R.color.brown_500,
        R.color.brown_600,
        R.color.brown_700,
        R.color.brown_800,
        R.color.brown_900,
        R.color.grey_50,
        R.color.grey_100,
        R.color.grey_200,
        R.color.grey_300,
        R.color.grey_400,
        R.color.grey_500,
        R.color.grey_600,
        R.color.grey_700,
        R.color.grey_800,
        R.color.grey_900,
        R.color.blue_grey_50,
        R.color.blue_grey_100,
        R.color.blue_grey_200,
        R.color.blue_grey_300,
        R.color.blue_grey_400,
        R.color.blue_grey_500,
        R.color.blue_grey_600,
        R.color.blue_grey_700,
        R.color.blue_grey_800,
        R.color.blue_grey_900,
    )

    @JvmStatic
    fun isDeviceLand(resources: Resources) =
        resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE

    @JvmStatic
    fun getDefaultNightMode(context: Context) = when (vectorifyPreferences.theme) {
        context.getString(R.string.theme_pref_light) -> AppCompatDelegate.MODE_NIGHT_NO
        context.getString(R.string.theme_pref_dark) -> AppCompatDelegate.MODE_NIGHT_YES
        else -> if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        } else {
            AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
        }
    }

    @JvmStatic
    fun getNextDefaultNightMode(context: Context) = when (vectorifyPreferences.theme) {
        context.getString(R.string.theme_pref_light) -> context.getString(R.string.theme_pref_dark)
        context.getString(R.string.theme_pref_dark) -> context.getString(R.string.theme_pref_auto)
        else -> context.getString(R.string.theme_pref_light)
    }

    @JvmStatic
    fun getDefaultNightModeIcon(context: Context) = when (vectorifyPreferences.theme) {
        context.getString(R.string.theme_pref_light) -> R.drawable.ic_theme_light
        context.getString(R.string.theme_pref_dark) -> R.drawable.ic_theme_night
        else -> R.drawable.ic_theme_auto
    }

    //method to open live wallpaper intent
    @JvmStatic
    fun openLiveWallpaperIntent(context: Context) {
        val intent = Intent(
            WallpaperManager.ACTION_CHANGE_LIVE_WALLPAPER
        )
        intent.putExtra(
            WallpaperManager.EXTRA_LIVE_WALLPAPER_COMPONENT,
            ComponentName(context, LiveWallpaper::class.java)
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS or Intent.FLAG_ACTIVITY_NO_ANIMATION)
        context.startActivity(intent)
    }

    //get system accent color
    @JvmStatic
    fun getSystemAccentColor(context: Context): Int {
        return try {
            ContextCompat.getColor(
                context,
                context.resources.getIdentifier("accent_device_default_dark", "color", "android")
            )
        } catch (e: Exception) {
            e.printStackTrace()
            ContextCompat.getColor(context, R.color.default_accent_color)
        }
    }

    @JvmStatic
    fun drawBitmap(
        drawable: Drawable?,
        canvas: Canvas,
        deviceWidth: Int,
        deviceHeight: Int,
        scale: Float,
        horizontalOffset: Float,
        verticalOffset: Float
    ) {

        val dimension = if (deviceWidth > deviceHeight) {
            deviceHeight
        } else {
            deviceWidth
        }
        val bitmap = Bitmap.createBitmap(
            (dimension * scale).toInt(),
            (dimension * scale).toInt(), Bitmap.Config.ARGB_8888
        )

        val drawableCanvas = Canvas(bitmap)
        drawable?.setBounds(0, 0, drawableCanvas.width, drawableCanvas.height)
        drawable?.draw(drawableCanvas)

        val left = canvas.width / 2F - drawableCanvas.width / 2F + horizontalOffset
        val top = canvas.height / 2F - drawableCanvas.width / 2F + verticalOffset

        canvas.drawBitmap(
            bitmap,
            left,
            top,
            null
        )
    }

    //determine if the live wallpaper is already applied
    @JvmStatic
    fun isLiveWallpaperRunning(context: Context): Boolean {
        val wpm = WallpaperManager.getInstance(context)
        val info = wpm.wallpaperInfo
        return info != null && info.packageName == context.packageName
    }

    //get categories start position
    @JvmStatic
    fun getCategory(context: Context, index: Int): Pair<String, List<Int>> {
        return when (index) {
            0 -> Pair(context.getString(R.string.title_tech), VectorsCategories.TECH) //tech
            1 -> Pair(
                context.getString(R.string.title_symbols),
                VectorsCategories.SYMBOLS
            ) //symbols
            2 -> Pair(
                context.getString(R.string.title_animals),
                VectorsCategories.ANIMALS
            ) //animals
            3 -> Pair(
                context.getString(R.string.title_emoticons),
                VectorsCategories.EMOTICONS
            ) //emoticons
            4 -> Pair(context.getString(R.string.title_fun), VectorsCategories.FUN) //fun
            5 -> Pair(context.getString(R.string.title_food), VectorsCategories.FOOD) //food
            6 -> Pair(context.getString(R.string.title_nature), VectorsCategories.NATURE) //nature
            7 -> Pair(
                context.getString(R.string.title_weather),
                VectorsCategories.WEATHER
            ) //weather
            8 -> Pair(context.getString(R.string.title_sport), VectorsCategories.SPORT) //sport
            9 -> Pair(context.getString(R.string.title_math), VectorsCategories.MATH) //math
            10 -> Pair(
                context.getString(R.string.title_science),
                VectorsCategories.SCIENCE
            ) //science
            11 -> Pair(
                context.getString(R.string.title_chernoff),
                VectorsCategories.CHERNOFF
            ) //Chernoff faceS
            12 -> Pair(context.getString(R.string.title_music), VectorsCategories.MUSIC) //music
            13 -> Pair(context.getString(R.string.title_nerdy), VectorsCategories.NERDY) //nerdy
            14 -> Pair(
                context.getString(R.string.title_buildings),
                VectorsCategories.BUILDINGS
            ) //buildings
            15 -> Pair(context.getString(R.string.title_alert), VectorsCategories.ALERT) //alert
            16 -> Pair(
                context.getString(R.string.title_alpha),
                VectorsCategories.ALPHABET
            ) //letters
            17 -> Pair(context.getString(R.string.title_roman), VectorsCategories.ROMAN) //roman
            18 -> Pair(context.getString(R.string.title_zodiac), VectorsCategories.ZODIAC) //zodiac
            else -> Pair(context.getString(R.string.title_others), VectorsCategories.OTHERS)
        }
    }

    @JvmStatic
    fun getVectorProps(vector: Int): Pair<Int, Boolean> {

        var isSpecial = false
        var returnedVector = vector
        when (vector) {

            R.drawable.m_original -> {
                returnedVector = R.drawable.m
                isSpecial = true
            }

            R.drawable.n_original -> {
                returnedVector = R.drawable.n
                isSpecial = true
            }

            R.drawable.o_original -> {
                returnedVector = R.drawable.o
                isSpecial = true
            }
        }
        return Pair(returnedVector, isSpecial)
    }

    @JvmStatic
    fun tintDrawable(
        context: Context,
        vector: Int,
        vectorColor: Int
    ): Drawable? {

        //determine if we are facing android m, n, o vectors
        //so we can apply multiply tint mode to drawable
        val vectorProps = getVectorProps(vector)

        val bit = ContextCompat.getDrawable(context, vectorProps.first)

        bit?.let { b ->
            try {
                //to avoid shared drawables get tinted too!
                b.mutate()

                //set tint mode multiply for special vectors
                if (vectorProps.second) {
                    b.setTintMode(PorterDuff.Mode.MULTIPLY)
                }
                b.setTint(vectorColor)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        return bit
    }

    @JvmStatic
    fun openCustomTab(
        context: Context
    ) {
        try {
            CustomTabsIntent.Builder().apply {
                setShareState(CustomTabsIntent.SHARE_STATE_ON)
                setShowTitle(true)
                val link = context.getString(R.string.app_github_link)
                build().launchUrl(context, link.toUri())
            }
        } catch (e: Exception) {
            Toast.makeText(
                context,
                R.string.install_browser_message,
                Toast.LENGTH_LONG
            ).show()
            e.printStackTrace()
        }
    }

    @JvmStatic
    fun createColouredRipple(context: Context, rippleColor: Int): Drawable {
        val ripple = ContextCompat.getDrawable(context, R.drawable.ripple) as RippleDrawable
        ripple.setColor(ColorStateList.valueOf(rippleColor))
        return ripple
    }
}
