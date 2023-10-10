<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
android:layout_width="match_parent"
android:layout_height="90dp"
xmlns:app="http://schemas.android.com/apk/res-auto">

<TextView
android:id="@+id/tv_userId"
android:gravity="center"
android:textSize="16sp"
android:textStyle="bold"
android:layout_width="0dp"
android:layout_height="0dp"
app:layout_constraintWidth_percent="0.3"
app:layout_constraintLeft_toLeftOf="parent"
app:layout_constraintTop_toTopOf="parent"
app:layout_constraintBottom_toBottomOf="parent"/>

<TextView
android:id="@+id/tv_userName"
android:gravity="center"
android:textSize="16sp"
android:textStyle="bold"
android:layout_width="0dp"
android:layout_height="0dp"
app:layout_constraintWidth_percent="0.5"
app:layout_constraintLeft_toRightOf="@id/tv_userId"
app:layout_constraintTop_toTopOf="parent"
app:layout_constraintBottom_toBottomOf="parent"/>

<CheckBox
android:id="@+id/checkbox_user"
android:layout_width="0dp"
android:layout_height="0dp"
app:layout_constraintLeft_toRightOf="@id/tv_userName"
app:layout_constraintRight_toRightOf="parent"
app:layout_constraintTop_toTopOf="parent"
app:layout_constraintBottom_toBottomOf="parent"/>

</androidx.constraintlayout.widget.ConstraintLayout>