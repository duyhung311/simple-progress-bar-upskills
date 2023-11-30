package com.upskills.progressbar

import com.intellij.ide.ui.LafManagerListener
import com.intellij.openapi.Disposable
import com.intellij.openapi.application.ApplicationManager
import javax.swing.UIManager

class UpskillsApplicationComponent : Disposable {
    init {
        ApplicationManager
            .getApplication()
            .messageBus
            .connect(this)
            .subscribe(LafManagerListener.TOPIC, LafManagerListener { updateProgressBarUi() })
        updateProgressBarUi()
    }

    private fun updateProgressBarUi() {
        UIManager.put("ProgressBarUI", UpskillsProgressBarUi::class.java.name)
        UIManager.getDefaults()[UpskillsProgressBarUi::class.java.name] = UpskillsProgressBarUi::class.java
    }

    override fun dispose() = Unit
}
