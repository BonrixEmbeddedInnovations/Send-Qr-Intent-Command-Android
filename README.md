# CommandIntentApp

An Android app that demonstrates sending custom intents to other apps for dynamic QR code generation, payment processing, and related tasks.

## Overview

The `CommandIntentApp` is designed to interact with other Android apps by sending custom intents with specific data. This app can be used for a variety of tasks, including generating and displaying dynamic QR codes, sending payment details, and interacting with third-party apps that handle these commands.

## Features

- **Toolbar and Edge-to-Edge Support**: The app uses an edge-to-edge design to make the UI look modern, along with a custom toolbar for navigation.
- **App Selection Spinner**: A dropdown spinner allows the user to select the target app for sending intents.
- **Send Dynamic Data via Intents**: Various buttons enable users to send different commands to the selected target app, including:
  - Welcome screen command
  - Payment amount details
  - QR code generation
  - Success, failure, and cancellation screens
  - Total amount summary screen
  - Item detail screen
- **Custom Dialog**: A custom dialog is available to input and send payment amounts.
- **Multiple Colored Buttons**: Buttons with different colors are available for various actions, making the interface visually distinct.

## Screenshots

<p align="center">
  <img src="https://github.com/user-attachments/assets/8c4df24d-85cd-45d2-aacb-8a960f2b4ef2" alt="Splash Screen" width="30%" />
  <img src="https://github.com/user-attachments/assets/2b206858-85ed-482c-87db-defd2b2eab16" alt="Main Dialog" width="30%" />
  <img src="https://github.com/user-attachments/assets/dd575833-da0b-4a10-9f0c-1933b4457b38" alt="Custom Screen" width="30%" />
</p>

## Prerequisites

- Android Studio
- Android device or emulator running Android API level 21 or higher

## Getting Started

### Installation

1. Clone the repository:
    ```sh
    git clone https://github.com/BonrixEmbeddedInnovations/Send-Qr-Intent-Command-Android
    ```
2. Open the project in Android Studio.
3. Sync the project to install required dependencies.
4. Run the project on an emulator or Android device.

### Usage

1. **Select Target App**: Use the dropdown spinner to select the app that should receive the intent.
2. **Enter Amount and Note**: Enter the payment amount and note, if required.
3. **Choose an Action**:
   - `Button 1` - Send a welcome command to the selected app.
   - `Button 2` - Send a dynamic QR code with a specified amount.
   - `Button 3` - Display a success QR code screen with details.
   - `Button 4` - Display a failure QR code screen.
   - `Button 5` - Display a cancellation QR code screen.
   - `Button 6` - Display a total screen with amount details.
   - `Button 7` - Display an item screen with product details.

4. **Send Payment Amount**: Click on "Send Amount" to open a custom dialog to enter an amount and send it to the selected app.

### Customization

- The package names for the target apps are stored in the `values` array. You can update these package names to target your own apps.
- Modify the keys in the `putExtra()` calls to align with the commands expected by the receiving apps.
