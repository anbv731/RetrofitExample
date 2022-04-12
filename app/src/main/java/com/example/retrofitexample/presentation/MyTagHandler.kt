package com.example.retrofitexample.presentation

import android.text.Editable
import android.text.Html.TagHandler
import org.xml.sax.XMLReader


class MyTagHandler : TagHandler {
        override fun handleTag(
            opening: Boolean, tag: String, output: Editable,
            xmlReader: XMLReader?
        ) {
            if (tag == "ul" && !opening) output.append("\n")
            if (tag == "li" && opening) output.append("\n\t•")
        }
    }
