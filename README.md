NotificationPOC
===============

This project was built to demonstrate the ability to launch the application from a notification and return to the user's last visible activity rather than starting the application from its initial state.

I was experiencing an issue with an application I was contributing to that was not exhibiting this behavior.  Old school Notifications (pre-Notification.Builder or NotificationCompat.Builder) do not appear to adhere to the launch_mode and category settings on the PendingIntent.

To demonstrate what should happen:

1. Launch the application
2. Click the button to open Activity Two
3. Click the button to create a notification

Now ...

4. Open the notification shutter and click the notification.  The application should be brought into the foreground and you should be on Activity Two.
5. Repeat steps 1-3 above but this time hit the back button before displaying and clicking the notification.  The application should be brought into the foreground and you should be on Activity One.
6. Repeat steps 1-3 above and press the home button from either Activity One or Activity Two.  Again, when clikcing the notification you should end up on the same activity that was being displayed when you left the application.
7. Finally, repeat steps 1-3 above but this time, before clicking the notification, clear the app from recents effectively closing it completely.  Now when you click the notification the application should be opened and the launch acitivty, Activity One, should be displayed.
