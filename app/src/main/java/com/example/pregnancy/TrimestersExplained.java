package com.example.pregnancy;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TrimestersExplained extends AppCompatActivity {

    String trimester_number;
    TextView trimesterToolBarHeading;
    Spinner trimester_weeks_selector;
    List<String> weeks;

    private class TrimesterData{
        public int trimesterImage;
        public String trimesterHeading, trimesterText;

        public TrimesterData(String trimesterHeading, String trimesterText, int trimesterImage){
            this.trimesterHeading = trimesterHeading;
            this.trimesterText = trimesterText;
            this.trimesterImage = trimesterImage;
        }

        public int getTrimesterImage() {
            return trimesterImage;
        }

        public void setTrimesterImage(int trimesterImage) {
            this.trimesterImage = trimesterImage;
        }

        public String getTrimesterHeading() {
            return trimesterHeading;
        }

        public void setTrimesterHeading(String trimesterHeading) {
            this.trimesterHeading = trimesterHeading;
        }

        public String getTrimesterText() {
            return trimesterText;
        }

        public void setTrimesterText(String trimesterText) {
            this.trimesterText = trimesterText;
        }
    }

    ArrayList<TrimesterData> trimestersInformation;

    ImageView weeks_image;
    TextView weeks_heading, weeks_text, nextWeek, previousWeek, currentWeek;
    ImageButton addFont, reduceFont, readText;
    static float setFont;

    ImageView trimesterExplainedBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trimesters_explained);

        getSupportActionBar().hide();

        trimesterExplainedBack = findViewById(R.id.trimesterExplainedBack);

        trimesterExplainedBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Guide.class));
            }
        });

        weeks_image = findViewById(R.id.trimester_week_image);
        weeks_heading = findViewById(R.id.trimester_week_heading);
        weeks_text = findViewById(R.id.trimester_week_text);

        nextWeek = findViewById(R.id.nextWeekText);
        previousWeek = findViewById(R.id.previousWeekText);
        currentWeek = findViewById(R.id.currentWeek);

        addFont = findViewById(R.id.addFont);
        reduceFont = findViewById(R.id.reduceFont);
        readText = findViewById(R.id.readText);

        setFont = weeks_text.getTextSize();

        addFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                float unit = 0.5f;

                setFont += unit;

                weeks_text.setTextSize(setFont + unit);
            }
        });

        reduceFont.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float unit = 0.5f;

                setFont -= unit;

                weeks_text.setTextSize(setFont + unit);
            }
        });


        readText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tools.tts.speak(weeks_heading.getText() + ". " + weeks_text.getText(), TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        Bundle bundle = getIntent().getExtras();

        assert bundle != null;

        trimester_number = bundle.getString("trimester_number");

        trimesterToolBarHeading = findViewById(R.id.trimester_heading);
        trimesterToolBarHeading.setText("Fetal Development: "+trimester_number);
        
        trimester_weeks_selector = findViewById(R.id.trimester_weeks);
        
        weeks = new ArrayList<>();
        
        int j = 1;
        
        if(trimester_number.equals("Trimester 1")){
            j = 1;
            trimestersInformation = new ArrayList<>();
            trimestersInformation.add(new TrimesterData("Weeks 1: Getting ready", "It might seem strange, but you're not actually pregnant the first week or two of the time allotted to your pregnancy. Yes, you read that correctly!\n" +
                    "\n" +
                    "Conception typically occurs about two weeks after your last period begins. To calculate your estimated due date, your health care provider will count ahead 40 weeks from the start of your last period. This means your period is counted as part of your pregnancy — even though you weren't pregnant at the time.",
                    0));

            trimestersInformation.add(new TrimesterData("Weeks 2: Getting ready", "It might seem strange, but you're not actually pregnant the first week or two of the time allotted to your pregnancy. Yes, you read that correctly!\n" +
                    "\n" +
                    "Conception typically occurs about two weeks after your last period begins. To calculate your estimated due date, your health care provider will count ahead 40 weeks from the start of your last period. This means your period is counted as part of your pregnancy — even though you weren't pregnant at the time.",
                    0));

            trimestersInformation.add(new TrimesterData("Week 3: Fertilization", "The sperm and egg unite in one of your fallopian tubes to form a one-celled entity called a zygote. If more than one egg is released and fertilized or if the fertilized egg splits into two, you might have multiple zygotes.\n" +
                    "\n" +
                    "The zygote typically has 46 chromosomes — 23 from the biological mother and 23 from the biological father. These chromosomes help determine your baby's sex and physical traits.\n" +
                    "\n" +
                    "Soon after fertilization, the zygote travels down the fallopian tube toward the uterus. At the same time, it will begin dividing to form a cluster of cells resembling a tiny raspberry — a morula.",
                    R.drawable.week3));

            trimestersInformation.add(new TrimesterData("Week 4: Implantation", "The rapidly dividing ball of cells — now known as a blastocyst — has begun to burrow into the uterine lining (endometrium). This process is called implantation.\n" +
                    "\n" +
                    "Within the blastocyst, the inner group of cells will become the embryo. The outer layer will give rise to part of the placenta, which will nourish your baby throughout the pregnancy.",
                    0));

            trimestersInformation.add(new TrimesterData("Week 5: Hormone levels increase", "The fifth week of pregnancy, or the third week after conception, the levels of HCG hormone produced by the blastocyst quickly increase. This signals your ovaries to stop releasing eggs and produce more estrogen and progesterone. Increased levels of these hormones stop your menstrual period, often the first sign of pregnancy, and fuel the growth of the placenta.\n" +
                    "\n" +
                    "The embryo is now made of three layers. The top layer — the ectoderm — will give rise to your baby's outermost layer of skin, central and peripheral nervous systems, eyes, and inner ears.\n" +
                    "\n" +
                    "Your baby's heart and a primitive circulatory system will form in the middle layer of cells — the mesoderm. This layer of cells will also serve as the foundation for your baby's bones, ligaments, kidneys and much of the reproductive system.\n" +
                    "\n" +
                    "The inner layer of cells — the endoderm — is where your baby's lungs and intestines will develop.",
                    R.drawable.week5));

            trimestersInformation.add(new TrimesterData("Week 6: The neural tube closes", "Growth is rapid this week. Just four weeks after conception, the neural tube along your baby's back is closing. The baby's brain and spinal cord will develop from the neural tube. The heart and other organs also are starting to form.\n" +
                    "\n" +
                    "Structures necessary to the formation of the eyes and ears develop. Small buds appear that will soon become arms. Your baby's body begins to take on a C-shaped curvature.",
                    R.drawable.week6));

            trimestersInformation.add(new TrimesterData("Week 7: Baby's head develops", "Seven weeks into your pregnancy, or five weeks after conception, your baby's brain and face are growing. Depressions that will give rise to nostrils become visible, and the beginnings of the retinas form.\n" +
                    "\n" +
                    "Lower limb buds that will become legs appear and the arm buds that sprouted last week now take on the shape of paddles.",
                    R.drawable.week7));

            trimestersInformation.add(new TrimesterData("Week 8: Baby's nose forms", "Eight weeks into your pregnancy, or six weeks after conception, your baby's lower limb buds take on the shape of paddles. Fingers have begun to form. Small swellings outlining the future shell-shaped parts of your baby's ears develop and the eyes become obvious. The upper lip and nose have formed. The trunk and neck begin to straighten.\n" +
                    "\n" +
                    "By the end of this week, your baby might be about 1/2 inch (11 to 14 millimeters) long from crown to rump — about half the diameter of a U.S. quarter.",
                    R.drawable.week8));

            trimestersInformation.add(new TrimesterData("Week 9: Baby's toes appear", "In the ninth week of pregnancy, or seven weeks after conception, your baby's arms grow and elbows appear. Toes are visible and eyelids form. Your baby's head is large but still has a poorly formed chin.\n" +
                    "\n" +
                    "By the end of this week, your baby might be a little less than 3/4 inch (16 to 18 millimeters) long from crown to rump — the diameter of a U.S. penny.",
                    R.drawable.week9));

            trimestersInformation.add(new TrimesterData("Week 10: Baby's elbows bend", "By the 10th week of pregnancy, or eight weeks after conception, your baby's head has become more round.\n" +
                    "\n" +
                    "Your baby can now bend his or her elbows. Toes and fingers lose their webbing and become longer. The eyelids and external ears continue to develop. The umbilical cord is clearly visible.",
                    R.drawable.week10));

            trimestersInformation.add(new TrimesterData("Week 11: Baby's genitals develop", "At the beginning of the 11th week of pregnancy, or the ninth week after conception, your baby's head still makes up about half of its length. However, your baby's body is about to catch up.\n" +
                    "\n" +
                    "Your baby is now officially described as a fetus. This week your baby's face is broad, the eyes widely separated, the eyelids fused and the ears low set. Buds for future teeth appear. Red blood cells are beginning to form in your baby's liver. By the end of this week, your baby's external genitalia will start developing into a penis or a clitoris and labia majora.\n" +
                    "\n" +
                    "By now your baby might measure about 2 inches (50 millimeters) long from crown to rump — the length of the short side of a credit card — and weigh almost 1/3 ounce (8 grams).",
                    0));

            trimestersInformation.add(new TrimesterData("Week 12: Baby's fingernails form", "Twelve weeks into your pregnancy, or 10 weeks after conception, your baby is sprouting fingernails. Your baby's face now has taken on a more developed profile. His or her intestines are in the abdomen.\n" +
                    "\n" +
                    "By now your baby might be about 2 1/2 inches (61 millimeters) long from crown to rump — the length of the short side of a U.S. bill — and weigh about 1/2 ounce (14 grams).",
                    R.drawable.week12));
        }else if(trimester_number.equals("Trimester 2")){
            j = 13;
            trimestersInformation = new ArrayList<>();

            trimestersInformation.add(new TrimesterData("Week 13: Urine forms", "As your pregnancy progresses, your baby might begin to seem more real. Two months ago, your baby was a cluster of cells. Now he or she has functioning organs, nerves and muscles. Find out what happens during the second trimester by checking out this weekly calendar of events. Keep in mind that measurements are approximate." +
                    "Thirteen weeks into your pregnancy, or 11 weeks after conception, your baby is beginning to make urine and release it into the surrounding amniotic fluid. Your baby also swallows some amniotic fluid.\n" +
                    "\n" +
                    "Bones are beginning to harden in your baby's skeleton, especially in the skull and long bones. Your baby's skin is still thin and transparent, but it will start to thicken soon.",
                    0));

            trimestersInformation.add(new TrimesterData("Week 14: Baby's sex becoming apparent", "Fourteen weeks into your pregnancy, or 12 weeks after conception, your baby's neck has become more defined. Red blood cells are forming in your baby's spleen.\n" +
                    "\n" +
                    "Your baby's sex will become apparent this week or in the coming weeks.\n" +
                    "\n" +
                    "By now your baby might be almost 3 1/2 inches (87 millimeters) long from crown to rump and weigh about 1 1/2 ounces (45 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 15: Baby's scalp pattern develops", "Fifteen weeks into your pregnancy, or 13 weeks after conception, your baby is growing rapidly. Bone development continues and will soon become visible on ultrasound images. Your baby's scalp hair pattern also is forming.",0));

            trimestersInformation.add(new TrimesterData("Week 16: Baby's eyes move", "Sixteen weeks into your pregnancy, or 14 weeks after conception, your baby's head is erect. His or her eyes can slowly move. The ears are close to reaching their final position. Your baby's skin is getting thicker.\n" +
                    "\n" +
                    "Your baby's limb movements are becoming coordinated and can be detected during ultrasound exams. However, these movements are still too slight to be felt by you.\n" +
                    "\n" +
                    "By now your baby might be more than 4 1/2 inches (120 millimeters) long from crown to rump and weigh close to 4 ounces (110 grams).", R.drawable.week16));

            trimestersInformation.add(new TrimesterData("Week 17: Baby's toenails develop", "Seventeen weeks into your pregnancy, or 15 weeks after conception, toenails begin developing.\n" +
                    "\n" +
                    "Your baby is becoming more active in the amniotic sac, rolling and flipping. His or her heart is pumping about 100 pints of blood each day.", 0));

            trimestersInformation.add(new TrimesterData("Week 18: Baby begins to hear", "Eighteen weeks into your pregnancy, or 16 weeks after conception, your baby's ears begin to stand out on the sides of his or her head. Your baby might begin to hear sounds. The eyes are beginning to face forward. Your baby's digestive system has started working.\n" +
                    "\n" +
                    "By now your baby might be 5 1/2 inches (140 millimeters) long from crown to rump and weigh 7 ounces (200 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 19: Baby develops protective coating", "Nineteen weeks into your pregnancy, or 17 weeks after conception, growth slows.\n" +
                    "\n" +
                    "A greasy, cheeselike coating called vernix caseosa begins to cover your baby. The vernix caseosa helps protect your baby's delicate skin from abrasions, chapping and hardening that can result from exposure to amniotic fluid.\n" +
                    "\n" +
                    "For girls, the uterus and vaginal canal are forming.", 0));

            trimestersInformation.add(new TrimesterData("Week 20: The halfway point", "Halfway into your pregnancy, or 18 weeks after conception, you might be able to feel your baby's movements (quickening). Your baby is regularly sleeping and waking. He or she might be awakened by noises or your movements.\n" +
                    "\n" +
                    "By now your baby might be about 6 1/3 inches (160 millimeters) long from crown to rump and weigh more than 11 ounces (320 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 21: Baby can suck his or her thumb", "Twenty-one weeks into your pregnancy, or 19 weeks after conception, your baby is completely covered with a fine, downy hair called lanugo. The lanugo helps hold the vernix caseosa on the skin.\n" +
                    "\n" +
                    "The sucking reflex also is developing, enabling your baby to suck his or her thumb.", R.drawable.week21));

            trimestersInformation.add(new TrimesterData("Week 22: Baby's hair becomes visible", "Twenty-two weeks into your pregnancy, or 20 weeks after conception, your baby's eyebrows and hair are visible. Brown fat also is forming, the site of heat production.\n" +
                    "\n" +
                    "For boys, the testes have begun to descend.\n" +
                    "\n" +
                    "By now your baby might be 7 1/2 inches (190 millimeters) long from crown to rump and weigh about 1 pound (460 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 23: Fingerprints and footprints form", "Twenty-three weeks into your pregnancy, or 21 weeks after conception, your baby begins to have rapid eye movements. Ridges also form in the palms of the hands and soles of the feet that will later create the foundation for fingerprints and footprints.\n" +
                    "\n" +
                    "Your baby might begin hiccuping, causing jerking movements.", 0));

            trimestersInformation.add(new TrimesterData("Week 24: Baby's skin is wrinkled", "Twenty-four weeks into your pregnancy, or 22 weeks after conception, your baby's skin is wrinkled, translucent and pink to red because of visible blood in the capillaries.\n" +
                    "\n" +
                    "By now your baby might be about 8 inches (210 millimeters) long from crown to rump and weigh more than 1 1/3 pounds (630 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 25: Baby responds to your voice", "Twenty-five weeks into your pregnancy, or 23 weeks after conception, your baby might be able to respond to familiar sounds, such as your voice, with movement.\n" +
                    "\n" +
                    "Your baby is spending most of his or her sleep time in rapid eye movement (REM), when the eyes move rapidly even though the eyelids are closed.", R.drawable.week25));

            trimestersInformation.add(new TrimesterData("Week 26: Baby's lungs develop", "Twenty-six weeks into your pregnancy, or 24 weeks after conception, your baby's lungs are beginning to produce surfactant, the substance that allows the air sacs in the lungs to inflate — and keeps them from collapsing and sticking together when they deflate.\n" +
                    "\n" +
                    "By now your baby might be 9 inches (230 millimeters) long from crown to rump and weigh nearly 2 pounds (820 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 27: 2nd trimester ends", "This week marks the end of the second trimester. At 27 weeks, or 25 weeks after conception, your baby's nervous system is continuing to mature. Your baby is also gaining fat, which will help his or her skin look smoother.", 0));
        }else if(trimester_number.equals("Trimester 3")){
            j = 28;

            trimestersInformation = new ArrayList<>();
            trimestersInformation.add(new TrimesterData("Week 28: Baby's eyes partially open", "The end of your pregnancy is near! By now, you're eager to meet your baby face to face. Your uterus, however, is still a busy place. Here's a weekly calendar of events for fetal development during the third trimester. Keep in mind that measurements are approximate. Twenty-eight weeks into your pregnancy, or 26 weeks after conception, your baby's eyelids can partially open and eyelashes have formed. The central nervous system can direct rhythmic breathing movements and control body temperature.\n" +
                    "\n" +
                    "By now your baby might be nearly 10 inches (250 millimeters) long from crown to rump and weigh nearly 2 1/4 pounds (1,000 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 29: Baby kicks and stretches", "Twenty-nine weeks into your pregnancy, or 27 weeks after conception, your baby can kick, stretch and make grasping movements.", R.drawable.week29));

            trimestersInformation.add(new TrimesterData("Week 30: Baby's hair grows", "Thirty weeks into your pregnancy, or 28 weeks after conception, your baby's eyes can open wide. Your baby might have a good head of hair by this week. Red blood cells are forming in your baby's bone marrow.\n" +
                    "\n" +
                    "By now your baby might be more than 10 1/2 inches (270 millimeters) long from crown to rump and weigh nearly 3 pounds (1,300 grams).", R.drawable.week29));

            trimestersInformation.add(new TrimesterData("Week 31: Baby's rapid weight gain begins", "Thirty-one weeks into your pregnancy, or 29 weeks after conception, your baby has finished most of his or her major development. Now it's time to gain weight — quickly.", 0));

            trimestersInformation.add(new TrimesterData("Week 32: Baby practices breathing", "Thirty-two weeks into your pregnancy, or 30 weeks after conception, your baby's toenails are visible.\n" +
                    "\n" +
                    "The layer of soft, downy hair that has covered your baby's skin for the past few months (lanugo) starts to fall off this week.\n" +
                    "\n" +
                    "By now your baby might be 11 inches (280 millimeters) long from crown to rump and weigh 3 3/4 pounds (1,700 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 33: Baby detects light", "Thirty-three weeks into your pregnancy, or 31 weeks after conception, your baby's pupils can change size in response to a stimulus caused by light. His or her bones are hardening. However, the skull remains soft and flexible.", R.drawable.week33));

            trimestersInformation.add(new TrimesterData("Week 34: Baby's fingernails grow", "Thirty-four weeks into your pregnancy, or 32 weeks after conception, your baby's fingernails have reached his or her fingertips.\n" +
                    "\n" +
                    "By now your baby might be nearly 12 inches (300 millimeters) long from crown to rump and weigh more than 4 1/2 pounds (2,100 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 35: Baby's skin is smooth", "Thirty-five weeks into your pregnancy, or 33 weeks after conception, your baby's skin is becoming smooth. His or her limbs have a chubby appearance.", 0));

            trimestersInformation.add(new TrimesterData("Week 36: Baby takes up most of the amniotic sac", "Thirty-six weeks into your pregnancy, or 34 weeks after conception, the crowded conditions inside your uterus might make it harder for your baby to give you a punch. However, you'll probably still feel lots of stretches, rolls and wiggles.", 0));

            trimestersInformation.add(new TrimesterData("Week 37: Baby might turn head down", "Thirty-seven weeks into your pregnancy, or 35 weeks after conception, your baby has a firm grasp.\n" +
                    "\n" +
                    "To prepare for birth, your baby's head might start descending into your pelvis. If your baby isn't head down, your health care provider will talk to you about ways to deal with this issue.", 0));

            trimestersInformation.add(new TrimesterData("Week 38: Baby's toenails grow", "Thirty-eight weeks into your pregnancy, or 36 weeks after conception, the circumference of your baby's head and abdomen are about the same.\n" +
                    "\n" +
                    "Your baby's toenails have reached the tips of his or her toes. Your baby has mostly shed all of his or her lanugo.\n" +
                    "\n" +
                    "By now your baby might weigh about 6 1/2 pounds (2,900 grams).", 0));

            trimestersInformation.add(new TrimesterData("Week 39: Baby's chest is prominent", "Thirty-nine weeks into your pregnancy, or 37 weeks after conception, your baby's chest is becoming more prominent. For boys, the testes continue to descend into the scrotum. Fat is being added all over your baby's body to keep him or her warm after birth.", 0));

            trimestersInformation.add(new TrimesterData("Week 40: Your due date arrives", "Forty weeks into your pregnancy, or 38 weeks after conception, your baby might have a crown-to-rump length of around 14 inches (360 millimeters) and weigh 7 1/2 pounds (3,400 grams). Remember, however, that healthy babies come in different sizes.\n" +
                    "\n" +
                    "Don't be alarmed if your due date comes and goes with no signs of labor starting. Your due date is simply a calculated estimate of when your pregnancy will be 40 weeks. It does not estimate when your baby will arrive. It's normal to give birth before or after your due date.", R.drawable.week40));
        }
        
        for(int i = 0; i < trimestersInformation.size(); i++){
            weeks.add("Week " + (j + i));
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, weeks);
        trimester_weeks_selector.setAdapter(adapter);

        trimester_weeks_selector.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                ((TextView) adapterView.getChildAt(0)).setTextColor(Color.WHITE);

                if((trimestersInformation.get(i).getTrimesterImage()) == 0){
                    weeks_image.setVisibility(View.GONE);
                }else{
                    weeks_image.setImageResource(trimestersInformation.get(i).getTrimesterImage());

                    weeks_image.setVisibility(View.VISIBLE);
                }
                weeks_heading.setText(trimestersInformation.get(i).getTrimesterHeading());
                weeks_text.setText(trimestersInformation.get(i).getTrimesterText());

                if(i == 0){
                    previousWeek.setText("Week 0");
                    currentWeek.setText("Current: Week " + (i + 1));
                    nextWeek.setText("Week " + (i + 2));
                }else if(i == 11){
                    previousWeek.setText("Week " + 11);
                    currentWeek.setText("Current: Week " + (i + 1));
                    nextWeek.setText("Week " + 12);
                }else{
                    previousWeek.setText("Week " + i);
                    currentWeek.setText("Current: Week " + (i + 1));
                    nextWeek.setText("Week " + (i + 2));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}