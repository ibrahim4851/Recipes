package com.ibrahim.recipes.util

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class RecipeDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createCategoriesTableQuery = "CREATE TABLE $TABLE_CATEGORIES (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_CATEGORY_NAME TEXT," +
                "$COLUMN_CATEGORY_DESCRIPTION TEXT," +
                "$COLUMN_CATEGORY_PHOTO_PATH TEXT" +
                ")"
        db.execSQL(createCategoriesTableQuery)

        // Create the "recipes" table
        val createRecipesTableQuery = "CREATE TABLE $TABLE_RECIPES (" +
                "$COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COLUMN_RECIPE_NAME TEXT," +
                "$COLUMN_SELECTED_CATEGORY TEXT," +
                "$COLUMN_INGREDIENTS TEXT," +
                "$COLUMN_INSTRUCTIONS TEXT," +
                "$COLUMN_TEMPERATURE TEXT," +
                "$COLUMN_SELECTED_TIME TEXT," +
                "$COLUMN_RECIPE_PHOTO_PATH TEXT" +
                ")"
        db.execSQL(createRecipesTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_RECIPES")
        db.execSQL("DROP TABLE IF EXISTS $TABLE_INGREDIENTS")
        onCreate(db)
    }

    companion object {

        private const val DATABASE_NAME = "recipe.db"
        private const val DATABASE_VERSION = 1

        private const val TABLE_INGREDIENTS = "ingredients"
        private const val TABLE_RECIPES = "recipes"

        private const val COLUMN_CATEGORY_NAME = "categoryName"
        private const val COLUMN_CATEGORY_DESCRIPTION = "categoryDescription"
        private const val COLUMN_CATEGORY_PHOTO_PATH = "categoryPhotoPath"

        // Recipes table column names
        private const val COLUMN_RECIPE_NAME = "recipeName"
        private const val COLUMN_SELECTED_CATEGORY = "selectedCategory"
        private const val COLUMN_INGREDIENTS = "ingredients"
        private const val COLUMN_INSTRUCTIONS = "instructions"
        private const val COLUMN_TEMPERATURE = "temperature"
        private const val COLUMN_SELECTED_TIME = "selectedTime"
        private const val COLUMN_RECIPE_PHOTO_PATH = "recipePhotoPath"
    }

}