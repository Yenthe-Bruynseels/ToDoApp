package be.mindzz.mytodo.service

import android.accessibilityservice.AccessibilityService
import android.view.accessibility.AccessibilityEvent

class MyAccessibilityService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Called upon UI event
    }

    override fun onInterrupt() {
        // Unused, but required
    }
}