package com.tata.util;

public class EmailMessages {

    // Welcome Email
    public static String getWelcomeMessage(String name) {
        return """
                Hello %s,

                🎉 Welcome to InfoCircle!

                We're excited to have you in our community.
                You can now explore posts, share knowledge,
                and connect with others.

                Happy Learning!

                — Team InfoCircle
                """.formatted(name);
    }

    // Forgot Password Email
    public static String getResetPasswordMessage(String resetLink) {
        return """
                Password Reset Request

                We received a request to reset your password.

                Click the link below to reset your password:
                %s

                ⚠️ This link will expire in 15 minutes.

                If you didn't request this, ignore this email.

                — Team InfoCircle
                """.formatted(resetLink);
    }

}