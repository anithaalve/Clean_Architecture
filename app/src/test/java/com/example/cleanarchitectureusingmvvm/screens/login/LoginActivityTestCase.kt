//package com.example.cleanarchitectureusingmvvm.screens.login
//
//
//import org.junit.Test
//
///**
// *
// * Created by aalvekod on 28-03-2023.
// * **/
//class LoginActivityTestCase {
//    private var fragment: LoginActivityFragment? = null
//
//    @Test
//    fun testFragment() {
//        // Assumes that "MyDialogFragment" extends the DialogFragment class.
//        with(launchFragment<LoginActivityFragment>()) {
//            onFragment { fragment ->
//                assertThat(fragment.dialog).isNotNull()
//                assertThat(fragment.requireDialog().isShowing).isTrue()
//                fragment.dismiss()
//                fragment.parentFragmentManager.executePendingTransactions()
//                assertThat(fragment.dialog).isNull()
//            }
//        }
//
//        // Assumes that the dialog had a button
//        // containing the text "Cancel".
//        //onView(withText("Cancel")).check(doesNotExist())
//    }
//}