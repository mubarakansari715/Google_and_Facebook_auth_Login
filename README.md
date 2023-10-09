# Google_and_Facebook_auth_Login
=================================
# Facebook Login Integration:::

**1. Access the Facebook Developer Console:**

Go to the Facebook Developer website at https://developers.facebook.com/ and log in with your Facebook account.

**2. Select Your App:**

If you haven't already created an app, click on "My Apps" and select "Create App" to create one. Otherwise, select your existing app from the "My Apps" list.

**3. Navigate to the App Dashboard:**

After selecting your app, you'll be taken to the App Dashboard.

**4. Configure OAuth Redirect URI:**

In the App Dashboard, on the left sidebar, under "Settings," click on "Basic."

Facebook App Dashboard

**5. Scroll Down to "Facebook Login" Section:**

Scroll down to the "Facebook Login" section on the "Settings" page.

Facebook Login Settings

**6. Add or Edit the Valid OAuth Redirect URIs:**

Look for the "Valid OAuth Redirect URIs" field.
Add the OAuth Redirect URI that corresponds to your Android app's intent filter as specified in your AndroidManifest.xml file. It should be in the format fb<APP_ID>://authorize, where <APP_ID> is the unique identifier of your Facebook app.
For example, if your Facebook App ID is 1234567890, the OAuth Redirect URI might be fb1234567890://authorize.

OAuth Redirect URIs

**7. Save Changes:**

After adding the Redirect URI, don't forget to scroll to the bottom of the page and click the "Save Changes" button.

Confirmation:

You should see a confirmation dialog stating that the changes were saved successfully.

Now, your Android app should be able to use this OAuth Redirect URI for Facebook authentication. Make sure to configure your AndroidManifest.xml file as mentioned in the previous responses to handle the OAuth redirect URI properly in your Android app.


# Google Login Integration:: 

**1. Create a Firebase Project:**

If you don't have a Firebase project yet, go to the Firebase Console (https://console.firebase.google.com/) and create a new project.

**2. Add Your App to Firebase:**

After creating the Firebase project, click on "Add App" and select the Android platform.
Follow the setup instructions to add your app to Firebase. This includes adding the package name of your Android app.
Download Configuration File:

You will be prompted to download a google-services.json file. Place this file in the app module of your Android project.

**3. Add Dependencies:**

Open your app-level build.gradle file (usually located in the app module) and add the following dependencies:

**4. Initialize Firebase:**

In your Application class or in your main activity, initialize Firebase by adding the following code in the onCreate method:
