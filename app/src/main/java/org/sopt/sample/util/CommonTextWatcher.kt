package org.sopt.sample.util

import android.text.Editable
import android.text.TextWatcher

class CommonTextWatcher(
    private val afterChanged: ((Editable?) -> Unit) = {},
    private val beforeChanged: ((CharSequence?, Int, Int, Int) -> Unit) = { _, _, _, _ -> },
    private val onChanged: ((CharSequence?, Int, Int, Int) -> Unit) = { _, _, _, _ -> }
) : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        beforeChanged(s, start, count, after)
    }

    override fun onTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        onChanged(s, start, count, after)
    }

    override fun afterTextChanged(s: Editable?) {
        afterChanged(s)
    }
}
