package com.example.barcodescanner.feature.tabs.create.qr

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.example.barcodescanner.R
import com.example.barcodescanner.extension.isNotBlank
import com.example.barcodescanner.extension.textString
import com.example.barcodescanner.feature.tabs.create.BaseCreateBarcodeFragment
import com.example.barcodescanner.feature.tabs.create.CreateBarcodeActivity
import com.example.barcodescanner.model.schema.Other
import com.example.barcodescanner.model.schema.Schema
import kotlinx.android.synthetic.main.fragment_create_qr_code_text.*

class CreateQrCodeTextFragment : BaseCreateBarcodeFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_qr_code_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initEditText()
        handleTextChanged()
    }

    override fun getBarcodeSchema(): Schema {
        return Other(edit_text.textString)
    }

    private fun initEditText() {
        edit_text.requestFocus()
    }

    private fun handleTextChanged() {
        edit_text.addTextChangedListener {
            parentActivity.isCreateBarcodeButtonEnabled = edit_text.isNotBlank()
        }
    }
}