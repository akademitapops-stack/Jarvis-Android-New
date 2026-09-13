package com.hermes.jarvis;

import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SkillsActivity extends AppCompatActivity {

    private static final int BG = 0xFF02070D;
    private static final int TEXT_MAIN = 0xFFEAF7FF;
    private static final int MUTED = 0xFF6F8BA1;
    private static final int CYAN = 0xFF6FE3FF;
    private static final int GREEN = 0xFF58DFAE;
    private static final int AMBER = 0xFFFFB454;
    private static final int ITEM_BG = 0xFF081726;
    private static final int ITEM_BORDER = 0xFF173854;

    private static final String[][] SKILLS = {
            {"Chat / Agent loop", "READY", "green"},
            {"Memory", "READY", "green"},
            {"Web search", "READY", "green"},
            {"Weather", "READY", "green"},
            {"Voice / TTS", "READY", "green"},
            {"Vision camera", "READY", "green"},
            {"Contacts / Dialer", "READY", "green"},
            {"Notifications", "READY*", "amber"},
            {"Device controls", "READY", "green"},
            {"Terminal / root", "READY*", "amber"},
            {"Automation / reminders", "READY", "green"},
            {"Dashboard / HUD", "READY", "green"},
            {"Telegram bridge", "CONFIG-ONLY", "cyan"},
            {"WhatsApp Cloud API", "CONFIG-ONLY", "cyan"},
    };

    @Override protected void onCreate(Bundle b) {
        super.onCreate(b);
        setTitle("J.A.R.V.I.S. Skills");
        buildUi();
    }

    private int dp(float v) { return (int) (v * getResources().getDisplayMetrics().density + .5f); }

    private void buildUi() {
        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(BG);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(16), dp(16), dp(16), dp(24));

        TextView title = new TextView(this);
        title.setText("✧ SKILL MATRIX");
        title.setTextColor(CYAN);
        title.setTypeface(Typeface.MONOSPACE, Typeface.BOLD);
        title.setTextSize(17);
        title.setLetterSpacing(0.03f);
        root.addView(title);

        TextView sub = new TextView(this);
        sub.setText("Kemampuan aktif J.A.R.V.I.S. saat ini. * memerlukan izin Android / root.");
        sub.setTextColor(MUTED);
        sub.setTextSize(12);
        sub.setPadding(0, dp(4), 0, dp(16));
        root.addView(sub);

        for (String[] skill : SKILLS) root.addView(row(skill[0], skill[1], skill[2]));

        TextView footer = new TextView(this);
        footer.setText("J.A.R.V.I.S. v2.9 TITAN");
        footer.setTextColor(MUTED);
        footer.setTextSize(10);
        footer.setTypeface(Typeface.MONOSPACE);
        footer.setPadding(0, dp(16), 0, 0);
        footer.setGravity(Gravity.CENTER);
        root.addView(footer);

        scroll.addView(root);
        setContentView(scroll);
    }

    private LinearLayout row(String name, String status, String tone) {
        int color = tone.equals("green") ? GREEN : tone.equals("amber") ? AMBER : CYAN;

        LinearLayout item = new LinearLayout(this);
        item.setOrientation(LinearLayout.HORIZONTAL);
        item.setGravity(Gravity.CENTER_VERTICAL);
        item.setPadding(dp(12), dp(12), dp(12), dp(12));
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(ITEM_BG);
        bg.setStroke(dp(1), ITEM_BORDER);
        bg.setCornerRadius(dp(11));
        item.setBackground(bg);
        LinearLayout.LayoutParams itemLp = new LinearLayout.LayoutParams(-1, -2);
        itemLp.setMargins(0, 0, 0, dp(7));
        item.setLayoutParams(itemLp);

        TextView dot = new TextView(this);
        GradientDrawable dotBg = new GradientDrawable();
        dotBg.setShape(GradientDrawable.OVAL);
        dotBg.setColor(color);
        dot.setBackground(dotBg);
        LinearLayout.LayoutParams dotLp = new LinearLayout.LayoutParams(dp(9), dp(9));
        dotLp.setMarginEnd(dp(12));
        item.addView(dot, dotLp);

        TextView name_ = new TextView(this);
        name_.setText(name);
        name_.setTextColor(TEXT_MAIN);
        name_.setTextSize(13.5f);
        item.addView(name_, new LinearLayout.LayoutParams(0, -2, 1f));

        TextView badge = new TextView(this);
        badge.setText(status);
        badge.setTextColor(color);
        badge.setTypeface(Typeface.MONOSPACE);
        badge.setTextSize(10);
        badge.setLetterSpacing(0.04f);
        item.addView(badge);

        return item;
    }
}
