# Interactive Translator
# Importing libraries
import sys
from PyQt5.QtWidgets import QApplication, QLabel, QPushButton, QWidget, QGridLayout
from PyQt5.QtGui import QPixmap
from PyQt5 import QtGui, QtCore
from PyQt5.QtGui import QCursor
from googletrans import Translator
from PyQt5.QtWidgets import *
from PyQt5.QtGui import *
from PyQt5.QtCore import *
import pyttsx3

#Creating dictionary with key value pairs as linked lists
Widgets = {
    "logo": [],
    "lang_buttons": [],
    "german_buttons": [],
    "italian_buttons": [],
    "spanish_buttons": [],
    "french_buttons": [],
    "portuguese_buttons": [],
    "mainimage": [],
    "welcome": [],
    "button": [],
    "textbox": [],
    "comboBox": [],
    "spanish_logo": [],
    "italian_logo": [],
    "portuguese_logo": [],
    "french_logo": [],
    "german_logo": [],
    "other_logo": [],
    "German": [],
    "Spanish": [],
    "Italian": [],
    "French": [],
    "Portuguese": [],
    "other_buttons": [],
    "soption1": [],
    "soption2": [],
    "soption3": [],
    "soption4": [],
    "nextq": [],
    "endp": [],
    "italianopt1": [],
    "italianopt2": [],
    "italianopt3": [],
    "italianopt4": [],
    "germanopt1": [],
    "germanopt2": [],
    "germanopt3": [],
    "germanopt4": [],
    "frenchopt1": [],
    "frenchopt2": [],
    "frenchopt3": [],
    "frenchopt4": [],
    "portuguese_answer1": [],
    "portuguese_answer2": [],
    "portuguese_answer3": [],
    "portuguese_answer4": [],
    "trans_btn" :[],
    "italianbutt":[],
    "germanbutt":[],
    "frenchbutt":[],
    "spanishbutt":[],
    "portuguesebutt":[],
    "exitb":[]

}
Labels = {
    "italian_labels": [],
    "german_labels": [],
    "spanish_labels": [],
    "french_labels": [],
    "portuguese_labels": [],
    "other_labels": [],
    "spanish_ques": [],
    "wrong_ans": [],
    "correct_ans": [],
    "italian_ques": [],
    "german_ques": [],
    "portuguese_ques": [],
    "french_ques": [],
    "invilab":[]
}
Voice = {
    "voice_buttons": []
}

#Main Frame 
app = QApplication(sys.argv)
Window = QWidget()
Window.setWindowTitle("Interactive Translator")
Window.setStyleSheet("background-color: #BCEE68;")
Window.setGeometry(0, 0, 5000, 1000)
Window.setWindowIcon(QtGui.QIcon('translate.jpeg'))
grid = QGridLayout()
Window.setLayout(grid)

#User Defined functions for basic functions
def clear_widgets():
    for widget in Widgets:
        if Widgets[widget] != []:
            Widgets[widget][-1].hide()
        for i in range(0, len(Widgets[widget])):
            Widgets[widget].pop()

    for i in range(0, len(Labels["other_labels"])):
        Labels["other_labels"][i].hide()

    for i in range(0, len(Voice["voice_buttons"])):
        Voice["voice_buttons"][i].hide()
    for i in range(0, len(Labels["italian_labels"])):
        Labels["italian_labels"][i].hide()
    for i in range(0, len(Labels["spanish_labels"])):
        Labels["spanish_labels"][i].hide()
    for i in range(0, len(Labels["french_labels"])):
        Labels["french_labels"][i].hide()
    for i in range(0, len(Labels["portuguese_labels"])):
        Labels["portuguese_labels"][i].hide()
    for i in range(0, len(Labels["german_labels"])):
        Labels["german_labels"][i].hide()

    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["german_ques"])):
        Labels["german_ques"][i].hide()
    for i in range(0, len(Labels["italian_ques"])):
        Labels["italian_ques"][i].hide()
    for i in range(0, len(Labels["spanish_ques"])):
        Labels["spanish_ques"][i].hide()
    for i in range(0, len(Labels["french_ques"])):
        Labels["french_ques"][i].hide()
    for i in range(0, len(Labels["portuguese_ques"])):
        Labels["portuguese_ques"][i].hide()
    for i in range(0,len(Widgets["textbox"])):
        Widgets["textbox"][i].hide()
    for i in range(0,len(Widgets["lang_buttons"])):
        Widgets["lang_buttons"][i].hide()
    for i in range(0, len(Labels["invilab"])):
        Labels["invilab"][i].hide()
    for i in range(0,len(Widgets["german_buttons"])):
        Widgets["german_buttons"][i].hide()
    for i in range(0,len(Widgets["italian_buttons"])):
        Widgets["italian_buttons"][i].hide()
    for i in range(0,len(Widgets["spanish_buttons"])):
        Widgets["spanish_buttons"][i].hide()
    for i in range(0,len(Widgets["french_buttons"])):
        Widgets["french_buttons"][i].hide()
    for i in range(0,len(Widgets["portuguese_buttons"])):
        Widgets["portuguse_buttons"][i].hide()

def create_buttons(text):
    button = QPushButton(text)
    button.setText(text)
    button.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    button.setFixedWidth(800)
    button.setStyleSheet("*{border: 4px solid '#C84A6B';"
                         + "border-radius: 15px;" +
                         "font-size: 25px;" +
                         "color: 'black';" +
                         "padding: 15px 0;" +
                         "margin: 25px 150px;}" +
                         "*:hover{background:'#C84A6B';}")

    return button

def create_label(text):
    label = QLabel(text)
    label.setText(text)
    label.setAlignment(QtCore.Qt.AlignCenter)
    label.setFixedWidth(800)
    label.setStyleSheet("*{border: 4px solid '#5D478B';" +
                        "background-color: #BDA0CB; "
                        + "border-radius: 15px;" +
                        "font-size: 25px;" +
                        "color: 'black';" +
                        "padding: 15px 0;" +
                        "margin: 25px 150px;}")
    return label

def create_voicebtns():
    button = QPushButton()
    button.setIcon(QIcon('speaker.png'))
    button.setIconSize(QtCore.QSize(35, 35))
    button.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    button.setFixedWidth(100)
    button.setStyleSheet("*{border: 4px solid '#BCEE68';"
                         + "border-radius: 15px;" +
                         "font-size: 25px;" +
                         "color: 'black';" +
                         "padding: 15px 0;" +
                         "margin: 25px 150px;}" +
                         "*:hover{background:'#BCEE68';}")

    return button

def voice():
    text = Widgets["textbox"][-1].text()
    combo_text = Widgets["comboBox"][-1].currentText()
    traslator = Translator()

    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    if (combo_text == "Italian"):

        engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate', rate - 75)
        result_i = traslator.translate(text, src='en', dest='it')
        engine.say(result_i.text)
        engine.runAndWait()


    elif (combo_text == "German"):

        engine.setProperty('voice',
                           'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate', rate - 75)
        result_g = traslator.translate(text, src='en', dest='de')
        engine.say(result_g.text)
        engine.runAndWait()

    elif (combo_text == "Portuguese"):

        engine.setProperty('voice',
                           'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate', rate - 75)
        result_p = traslator.translate(text, src='en', dest='pt')
        engine.say(result_p.text)
        engine.runAndWait()

    elif (combo_text == "French"):

        engine.setProperty('voice',
                           'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate', rate - 75)
        result_f = traslator.translate(text, src='en', dest='fr')
        engine.say(result_f.text)
        engine.runAndWait()

    elif (combo_text == "Spanish"):

        engine.setProperty('voice',
                           'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate', rate - 75)
        result_s = traslator.translate(text, src='en', dest='es')
        engine.say(result_s.text)
        engine.runAndWait()

def wrong_ans():
    wrong_anslabel = create_label("Wrong Answer!")
    wrong_anslabel.setFixedWidth(800)
    Labels["wrong_ans"].append(wrong_anslabel)
    grid.addWidget(Labels["wrong_ans"][-1], 4, 0)

def correct_ans():
    correct_anslabel = create_label("Correct Answer!")
    correct_anslabel.setFixedWidth(800)
    Labels["correct_ans"].append(correct_anslabel)
    grid.addWidget(Labels["correct_ans"][-1], 4, 0)

def clickMethod():
    text = Widgets["textbox"][-1].text()
    combo_text = Widgets["comboBox"][-1].currentText()
    translator = Translator()

    if combo_text == "Italian":
        result1 = translator.translate(text, src='en', dest='it')
        ansText = result1.text
        anslabel = create_label(ansText)
        anslabel.setFixedWidth(800)
        anslabel.setWordWrap(True)
        grid.addWidget(anslabel, 4, 1, 1, 1)

        Labels["other_labels"].append(anslabel)

        saybtn_i = create_voicebtns()
        Voice["voice_buttons"].append(saybtn_i)
        grid.addWidget(Voice["voice_buttons"][-1], 2, 2, 1, 1)
        saybtn_i.clicked.connect(voice)


    elif combo_text == "Spanish":
        result2 = translator.translate(text, src='en', dest='es')
        ansText = result2.text
        anslabel = create_label(ansText)
        anslabel.setFixedWidth(800)
        anslabel.setWordWrap(True)

        grid.addWidget(anslabel, 4, 1, 1, 1)
        Labels["other_labels"].append(anslabel)
        saybtn_s = create_voicebtns()
        Voice["voice_buttons"].append(saybtn_s)
        grid.addWidget(Voice["voice_buttons"][-1], 2, 2, 1, 1)
        saybtn_s.clicked.connect(voice)

    elif combo_text == "French":
        result3 = translator.translate(text, src='en', dest='fr')
        ansText = result3.text
        anslabel = create_label(ansText)
        anslabel.setFixedWidth(800)
        anslabel.setWordWrap(True)
        grid.addWidget(anslabel, 4, 1, 1, 1)
        Labels["other_labels"].append(anslabel)

        saybtn_f = create_voicebtns()
        Voice["voice_buttons"].append(saybtn_f)
        grid.addWidget(Voice["voice_buttons"][-1], 2, 2, 1, 1)
        saybtn_f.clicked.connect(voice)



    elif combo_text == "German":
        result4 = translator.translate(text, src='en', dest='de')
        ansText = result4.text
        anslabel = create_label(ansText)
        anslabel.setFixedWidth(800)
        anslabel.setWordWrap(True)
        grid.addWidget(anslabel, 4, 1, 1, 1)
        Labels["other_labels"].append(anslabel)

        saybtn_g = create_voicebtns()
        Voice["voice_buttons"].append(saybtn_g)
        grid.addWidget(Voice["voice_buttons"][-1], 2, 2, 1, 1)
        saybtn_g.clicked.connect(voice)

    elif combo_text == "Portuguese":
        result5 = translator.translate(text, src='en', dest='pt')
        ansText = result5.text
        anslabel = create_label(ansText)
        anslabel.setFixedWidth(800)
        anslabel.setWordWrap(True)
        grid.addWidget(anslabel, 4, 1, 1, 1)
        Labels["other_labels"].append(anslabel)

        saybtn_p = create_voicebtns()
        Voice["voice_buttons"].append(saybtn_p)
        grid.addWidget(Voice["voice_buttons"][-1], 2, 2, 1, 1)
        saybtn_p.clicked.connect(voice)
#Labels and Voice buttons for frames
    #German
def hello_german_translated():
    hello_label = create_label("Hallo")
    Labels["german_labels"].append(hello_label)
    grid.addWidget(Labels["german_labels"][-1], 1, 1, 1, 1)

def howareyou_german_translated():
    howareyou_label = create_label("Wie ghet es dir")
    Labels["german_labels"].append(howareyou_label)
    grid.addWidget(Labels["german_labels"][-1], 2, 1, 1, 1)

def goodmorning_german_translated():
    goodmorning_label = create_label("Guten morgan/nacht")
    Labels["german_labels"].append(goodmorning_label)
    grid.addWidget(Labels["german_labels"][-1], 3, 1, 1, 1)

def thankyou_german_translated():
    thankyou_label = create_label("Danke")
    Labels["german_labels"].append(thankyou_label)
    grid.addWidget(Labels["german_labels"][-1], 4, 1, 1, 1)
  
def canyouhelpmewith_german_translated():
    canyouhelpmewith_label = create_label("Kannst du mir dabei helfen")
    Labels["german_labels"].append(canyouhelpmewith_label)
    grid.addWidget(Labels["german_labels"][-1], 5, 1, 1, 1)
  
def sorry_german_translated():
    sorry_label = create_label("Verzeihung")
    Labels["german_labels"].append(sorry_label)
    grid.addWidget(Labels["german_labels"][-1], 1, 1, 1, 1)

def mayihavesomewater_german_translated():
    mayihavesomewater_label = create_label("Kann ich etwas wasser haben")
    Labels["german_labels"].append(mayihavesomewater_label)
    grid.addWidget(Labels["german_labels"][-1], 2, 1, 1, 1)

def yesno_german_translated():
    yesno_label = create_label("Jawohl/Nein")
    Labels["german_labels"].append(yesno_label)
    grid.addWidget(Labels["german_labels"][-1], 3, 1, 1, 1)

def whereareyoufrom_german_translated():
    whereareyoufrom_label = create_label("Woher kommst du")
    Labels["german_labels"].append(whereareyoufrom_label)
    grid.addWidget(Labels["german_labels"][-1], 4, 1, 1, 1)

def excuseme_german_translated():
    excuseme_label = create_label("Verzeihung")
    Labels["german_labels"].append(excuseme_label)
    grid.addWidget(Labels["german_labels"][-1], 5, 1, 1, 1)

def voice_hello_g() :
        engine = pyttsx3.init()
        voices = engine.getProperty('voices')

        engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate',rate-75)
        engine.say("Hallo ") 
        engine.runAndWait()

def voice_goodnight_g() :
        engine = pyttsx3.init()
        voices = engine.getProperty('voices') 

        engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate',rate-75)
        engine.say("Guten morgan / nacht") 
        engine.runAndWait() 
    
def voice_thankyou_g() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Danke") 
    engine.runAndWait() 

def voice_canyouhelpmewiththis_g() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Kannst du mir dabei helfen?") 
    engine.runAndWait() 

def voice_sorry_g() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Verzeihung") 
    engine.runAndWait() 

def voice_canihavesomewater_g() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Kann ich etwas wasser haben?") 
    engine.runAndWait() 

def voice_howareyou_g() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Wie ghet es dir") 
    engine.runAndWait() 

def voice_yesno_g() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Jawohl/Nein") 
    engine.runAndWait() 

def voice_whereareyoufrom_g() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Woher kommst du?") 
    engine.runAndWait() 

def voice_excuseme_g() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_DE-DE_HEDDA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Verzeihung") 
    engine.runAndWait() 


    #Italian
def hello_italian_translated():
    hello_label_i = create_label("Ciao/Arrivederci")
    Labels["italian_labels"].append(hello_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 1, 1, 1, 1)

def howareyou_italian_translated():
    howareyou_label_i = create_label("Come Va")
    Labels["italian_labels"].append(howareyou_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 2, 1, 1, 1)

def goodnight_i():
    goodnight_label_i = create_label(" Buongiorno/Buonnotte")
    Labels["italian_labels"].append(goodnight_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 3, 1, 1, 1)

def thankyou_i():
    thankyou_label_i = create_label("Grazie")
    Labels["italian_labels"].append(thankyou_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 4, 1, 1, 1)

def canyouhelpmewiththis_i():
    canyouhelpmewiththis_label_i = create_label("Puoi aiutarmi con questo")
    Labels["italian_labels"].append(canyouhelpmewiththis_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 5, 1, 1, 1)

def sorry_i():
    sorry_label_i = create_label("Susate")
    Labels["italian_labels"].append(sorry_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 1, 1, 1, 1)

def canihavesomewater_i():
    canihavesomewater_label_i = create_label("Posso avere dell'acqua")
    Labels["italian_labels"].append(canihavesomewater_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 2, 1, 1, 1)

def yesno_i():
    yesno_label_i = create_label("Si/No")
    Labels["italian_labels"].append(yesno_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 3, 1, 1, 1)

def whereareyoufrom_i():
    whereareyoufrom_label_i = create_label("Di dove sei")
    Labels["italian_labels"].append(whereareyoufrom_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 4, 1, 1, 1)

def excuseme_i():
    excuseme_label_i = create_label("Scusami")
    Labels["italian_labels"].append(excuseme_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 5, 1, 1, 1)

def name_i():
    name_label_i = create_label("Come ti chiami?")
    Labels["italian_labels"].append(name_label_i)
    grid.addWidget(Labels["italian_labels"][-1], 6, 1, 1, 1)

def voice_hello_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 75)
    engine.say("Ciao/Arrivederci ")
    engine.runAndWait()

def voice_goodnight_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 75)
    engine.say("Buona notte / Buon giorno")
    engine.runAndWait()

def voice_thankyou_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 50)
    engine.say("Grazie")
    engine.runAndWait()

def voice_canyouhelpmewiththis_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 50)
    engine.say("Puoi aiutarmi con questo?")
    engine.runAndWait()

def voice_sorry_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 50)
    engine.say("Scusate")
    engine.runAndWait()

def voice_canihavesomewater_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 50)
    engine.say("Posso avere dell'acqua?")
    engine.runAndWait()

def voice_howareyou_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 50)
    engine.say("Come Va")
    engine.runAndWait()

def voice_yesno_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 50)
    engine.say("Si'/No")
    engine.runAndWait()

def voice_whereareyoufrom_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')
    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 50)
    engine.say("Di dove sei?")
    engine.runAndWait()

def voice_excuseme_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 50)
    engine.say("Scusami")
    engine.runAndWait()

def voice_name_i():
    engine = pyttsx3.init()
    voices = engine.getProperty('voices')
    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_IT-IT_ELSA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate', rate - 50)
    engine.say("Come ti chiami?")
    engine.runAndWait()

    #Spanish
def hello_s():
    hello_slabel = create_label("Hola!")
    Labels["spanish_labels"].append(hello_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 1, 1, 1, 1)

def howareyou_s():
    howareyou_slabel = create_label("Cómo estás? / Estoy bien")
    Labels["spanish_labels"].append(howareyou_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 5, 1, 1, 1)

def sorry_s():
    sorry_slabel = create_label("Lo siento")
    Labels["spanish_labels"].append(sorry_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 2, 1, 1, 1)

def thankyou_s():
    thankyou_slabel = create_label("Gracias!")
    Labels["spanish_labels"].append(thankyou_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 3, 1, 1, 1)

def gm_s():
    gm_slabel = create_label("Buenos días/Buenes Noches")
    Labels["spanish_labels"].append(gm_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 4, 1, 1, 1)

def canyouhelp_s():
    canyouhelp_slabel = create_label("¿Puedes ayudarme con _____?")
    Labels["spanish_labels"].append(canyouhelp_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 6, 1, 1, 1)

def mayihave_s():
    mayihave_slabel = create_label("¿Me puede dar un poco de agua?")
    Labels["spanish_labels"].append(mayihave_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 1, 1, 1, 1)

def yesno_s():
    yesno_slabel = create_label("Sí / No")
    Labels["spanish_labels"].append(yesno_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 2, 1, 1, 1)

def whereareyoufrom_s():
    whereareyoufrom_slabel = create_label("¿De dónde eres?")
    Labels["spanish_labels"].append(whereareyoufrom_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 3, 1, 1, 1)

def excuseme_s():
    excuseme_slabel = create_label("Discúlpame")
    Labels["spanish_labels"].append(excuseme_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 4, 1, 1, 1)

def name_s():
    name_slabel = create_label("¿Cuál es su nombre? / Mi nombre es ____")
    Labels["spanish_labels"].append(name_slabel)
    grid.addWidget(Labels["spanish_labels"][-1], 5, 1, 1, 1)

def voice_hello_s() :
        engine = pyttsx3.init()
        voices = engine.getProperty('voices')

        engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate',rate-75)
        engine.say("Hola ") 
        engine.runAndWait() 

def voice_gm_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Buenos días Buenes Noches") 
    engine.runAndWait() 
    
def voice_thankyou_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Gracias") 
    engine.runAndWait() 

def voice_canyouhelp_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Puedes ayudarme con?") 
    engine.runAndWait() 

def voice_sorry_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Lo siento") 
    engine.runAndWait() 

def voice_mayihave_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Me puede dar un poco de agua?") 
    engine.runAndWait() 

def voice_howareyou_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Cómo estás?  Estoy bien") 
    engine.runAndWait() 

def voice_yesno_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Sí  No") 
    engine.runAndWait() 

def voice_whereareyoufrom_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("De dónde eres?") 
    engine.runAndWait() 

def voice_excuseme_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 
    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Discúlpame") 
    engine.runAndWait() 

def voice_name_s() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 
    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_ES-ES_HELENA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Cuál es su nombre?  Mi nombre es") 
    engine.runAndWait()

    #French
def hello_french_translated():
    hello_flabel = create_label("Bonjour/Au revoir")
    Labels["french_labels"].append(hello_flabel)
    grid.addWidget(Labels["french_labels"][-1], 1, 1, 1, 1)

def howareyou_french_translated():
    howareyou_flabel = create_label("Comment vas-tu?")
    Labels["french_labels"].append(howareyou_flabel)
    grid.addWidget(Labels["french_labels"][-1], 2, 1, 1, 1)

def goodnight_f():
    goodnight_flabel = create_label("Bonjour/Bonne nuit")
    Labels["french_labels"].append(goodnight_flabel)
    grid.addWidget(Labels["french_labels"][-1], 3, 1, 1, 1)

def thankyou_f():
    thankyou_flabel = create_label("Merci")
    Labels["french_labels"].append(thankyou_flabel)
    grid.addWidget(Labels["french_labels"][-1], 4, 1, 1, 1)

def canyouhelpmewiththis_f():
    canyouhelpmewiththis_flabel = create_label("Pouvez-vous m'aider avec?")
    Labels["french_labels"].append(canyouhelpmewiththis_flabel)
    grid.addWidget(Labels["french_labels"][-1], 5, 1, 1, 1)

def sorry_f():
    sorry_flabel = create_label("Pardon")
    Labels["french_labels"].append(sorry_flabel)
    grid.addWidget(Labels["french_labels"][-1], 1, 1, 1, 1)

def canihavesomewater_f():
    canihavesomewater_flabel = create_label("Puis-je avoir de l'eau?")
    Labels["french_labels"].append(canihavesomewater_flabel)
    grid.addWidget(Labels["french_labels"][-1], 2, 1, 1, 1)

def yesno_f():
    yesno_flabel = create_label("Oui/Non")
    Labels["french_labels"].append(yesno_flabel)
    grid.addWidget(Labels["french_labels"][-1], 3, 1, 1, 1)

def whereareyoufrom_f():
    whereareyoufrom_flabel = create_label("D'où viens-tu?")
    Labels["french_labels"].append(whereareyoufrom_flabel)
    grid.addWidget(Labels["french_labels"][-1], 4, 1, 1, 1)

def excuseme_f():
    excuseme_flabel = create_label("Excusez Moi")
    Labels["french_labels"].append(excuseme_flabel)
    grid.addWidget(Labels["french_labels"][-1], 5, 1, 1, 1)

def voice_hellogoodbye_f() :
        engine = pyttsx3.init()
        voices = engine.getProperty('voices')

        engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate',rate-75)
        engine.say("Bonjour/Au revoir ") 
        engine.runAndWait() 

def voice_goodnight_f() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Bonjour/Bonne nuit") 
    engine.runAndWait() 
    
def voice_thankyou_f() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Merci") 
    engine.runAndWait() 

def voice_canyouhelpmewiththis_f() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Pouvez-vous m'aider avec?") 
    engine.runAndWait() 

def voice_sorry_f() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Pardon") 
    engine.runAndWait() 

def voice_canihavesomewater_f() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Puis-je avoir de l'eau?") 
    engine.runAndWait() 

def voice_howareyou_f() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Comment vas-tu?") 
    engine.runAndWait() 

def voice_yesno_f() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Oui / Non") 
    engine.runAndWait() 

def voice_whereareyoufrom_f() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("D'où viens-tu?") 
    engine.runAndWait() 

def voice_excuseme_f() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_FR-FR_HORTENSE_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Excusez Moi") 
    engine.runAndWait()

    #Portuguese
def hello_portuguese_translated():
    hello_label = create_label("Olá / Adeus")
    Labels["portuguese_labels"].append(hello_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 1, 1, 1, 1)

def howareyou_portuguese_translated():
    howareyou_label = create_label("Como estás?")
    Labels["portuguese_labels"].append(howareyou_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 2, 1, 1, 1)

def goodnight_p():
    goodnight_label = create_label(" Bom dia/Boa noite ")
    Labels["portuguese_labels"].append(goodnight_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 3, 1, 1, 1)

def thankyou_p():
    thankyou_label = create_label("Obrigado")
    Labels["portuguese_labels"].append(thankyou_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 4, 1, 1, 1)

def canyouhelpmewiththis_p():
    canyouhelpmewiththis_label = create_label("Pode ajudar me com isto?")
    Labels["portuguese_labels"].append(canyouhelpmewiththis_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 5, 1, 1, 1)

def sorry_p():
    sorry_label = create_label("Desculpa")
    Labels["portuguese_labels"].append(sorry_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 1, 1, 1, 1)

def canihavesomewater_p():
    canihavesomewater_label = create_label("Posso ter um pouco de água?")
    Labels["portuguese_labels"].append(canihavesomewater_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 2, 1, 1, 1)

def yesno_p():
    yesno_label = create_label("Sim / Não")
    Labels["portuguese_labels"].append(yesno_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 3, 1, 1, 1)

def whereareyoufrom_p():
    whereareyoufrom_label = create_label("Di dove sei")
    Labels["portuguese_labels"].append(whereareyoufrom_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 4, 1, 1, 1)

def excuseme_p():
    excuseme_label = create_label("De onde és?")
    Labels["portuguese_labels"].append(excuseme_label)
    grid.addWidget(Labels["portuguese_labels"][-1], 5, 1, 1, 1)

def voice_hellogoodbye_p() :
        engine = pyttsx3.init()
        voices = engine.getProperty('voices')

        engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
        rate = engine.getProperty('rate')
        engine.setProperty('rate',rate-75)
        engine.say("Olá / Adeus ") 
        engine.runAndWait() 

def voice_goodnight_p() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-75)
    engine.say("Bom dia/Boa noite") 
    engine.runAndWait() 
    
def voice_thankyou_p() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Obrigado") 
    engine.runAndWait() 

def voice_canyouhelpmewiththis_p() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Pode ajudar me com isto ?") 
    engine.runAndWait() 

def voice_sorry_p() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Desculpa") 
    engine.runAndWait() 

def voice_canihavesomewater_p() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Posso ter um pouco de água?") 
    engine.runAndWait() 

def voice_howareyou_p() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Como estás?") 
    engine.runAndWait() 

def voice_yesno_p() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Sim / Não") 
    engine.runAndWait() 

def voice_whereareyoufrom_p() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("Di dove sei?") 
    engine.runAndWait() 

def voice_excuseme_p() :
    engine = pyttsx3.init()
    voices = engine.getProperty('voices') 

    engine.setProperty('voice', 'HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Speech\Voices\Tokens\TTS_MS_PT-BR_MARIA_11.0')
    rate = engine.getProperty('rate')
    engine.setProperty('rate',rate-50)
    engine.say("De onde és?") 
    engine.runAndWait()

#Frames
def welcome_frame():
    clear_widgets()
    image = QPixmap("welcome.png")
    welcome = QLabel()
    welcome.setPixmap(image)
    welcome.setAlignment(QtCore.Qt.AlignCenter)
    welcome.setStyleSheet("margin-top: 1px;")
    Widgets["welcome"].append(welcome)

    button = QPushButton("Enter")
    button.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    button.setStyleSheet("*{border: 4px solid '#C84A6B';" +
                         "border-radius: 30px;" +
                         "font-size: 35px;" +
                         "color: 'black';" +
                         "padding: 25px 0;" +
                         "margin: 100px 200px;}" +
                         "*:hover{background: '#C84A6B';}"
                         )
    button.clicked.connect(frame1)
    Widgets["button"].append(button)

    grid.addWidget(Widgets["welcome"][-1], 0, 0, 1, 1)
    grid.addWidget(Widgets["button"][-1], 1, 0, 1, 1)

def frame1():
    clear_widgets()
    for i in range(0, len(Voice["voice_buttons"])):
        Voice["voice_buttons"][i].hide()

    for i in range(0, len(Labels["invilab"])):
        Labels["invilab"][i].hide()

    for i in range(0,len(Widgets["german_buttons"])):
        Widgets["lang_buttons"][i].hide()
    for i in range(0,len(Widgets["italian_buttons"])):
        Widgets["lang_buttons"][i].hide()
    for i in range(0,len(Widgets["spanish_buttons"])):
        Widgets["lang_buttons"][i].hide()
    for i in range(0,len(Widgets["french_buttons"])):
        Widgets["lang_buttons"][i].hide()
    for i in range(0,len(Widgets["portuguese_buttons"])):
        Widgets["lang_buttons"][i].hide()

    
    image = QPixmap("translation.png")
    mainimage = QLabel()
    mainimage.setPixmap(image)
    mainimage.setAlignment(QtCore.Qt.AlignCenter)
    mainimage.setStyleSheet("margin-top: 1px;")
    Widgets["mainimage"].append(mainimage)

    button = QPushButton("Start")
    button.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    button.setStyleSheet("*{border: 4px solid '#C84A6B';"
                         + "border-radius: 15px;" +
                         "font-size: 30px;" +
                         "color: 'black';" +
                         "padding: 15px 0;" +
                         "margin: 25px 150px;}" +
                         "*:hover{background:'#C84A6B';}")
    button.clicked.connect(frame2)
    Widgets["button"].append(button)

    grid.addWidget(Widgets["mainimage"][-1], 0, 0, 1, 2)
    grid.addWidget(Widgets["button"][-1], 1, 0, 1, 1)

    quiz_button = QPushButton("Quiz")
    quiz_button.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    quiz_button.setStyleSheet("*{border: 4px solid '#C84A6B';"
                         + "border-radius: 15px;" +
                         "font-size: 30px;" +
                         "color: 'black';" +
                         "padding: 15px 0;" +
                         "margin: 25px 150px;}" +
                         "*:hover{background:'#C84A6B';}")

    Widgets["other_buttons"].append(quiz_button)
    grid.addWidget(Widgets["other_buttons"][-1], 1, 1, 1, 1)
    quiz_button.clicked.connect(quiz_start)

    testend_button = QPushButton("Exit Program")
    testend_button.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    testend_button.setStyleSheet("*{border: 4px solid '#C84A6B';"
                         + "border-radius: 15px;" +
                         "font-size: 30px;" +
                         "color: 'black';" +
                         "padding: 15px 0;" +
                         "margin: 8px 150px;}" +
                         "*:hover{background:'#C84A6B';}")

    Widgets["exitb"].append(testend_button)
    grid.addWidget(Widgets["exitb"][-1], 2, 0, 1, 2)
    testend_button.clicked.connect(exit)

def frame2():
    
    for i in range(0,len(Widgets["german_buttons"])):
        Widgets["german_buttons"][i].hide()
    for i in range(0,len(Widgets["italian_buttons"])):
        Widgets["italian_buttons"][i].hide()
    for i in range(0,len(Widgets["spanish_buttons"])):
        Widgets["spanish_buttons"][i].hide()
    for i in range(0,len(Widgets["french_buttons"])):
        Widgets["french_buttons"][i].hide()
    for i in range(0,len(Widgets["portuguese_buttons"])):
        Widgets["portuguese_buttons"][i].hide()
    
    for i in range(0, len(Voice["voice_buttons"])):
        Voice["voice_buttons"][i].hide()

    for i in range(0, len(Labels["other_labels"])):
        Labels["other_labels"][i].hide()

    for i in range(0, len(Labels["invilab"])):
        Labels["invilab"][i].hide()
    clear_widgets() 

    german_btn = QPushButton("German")
    german_btn.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    german_btn.setFixedWidth(800)
    german_btn.setStyleSheet("*{border: 4px solid '#C84A6B';"
                             + "border-radius: 15px;" +
                             "font-size: 25px;" +
                             "color: 'black';" +
                             "padding: 15px 0;" +
                             "margin: 25px 150px;}" +
                             "*:hover{background:'#C84A6B';}")

    Widgets["germanbutt"].append(german_btn)
    grid.addWidget(Widgets["germanbutt"][-1], 1, 0, 1, 1)
    german_btn.clicked.connect(german_frame1)
    image = QPixmap("germany_flag.png")
    german_logo = QLabel()
    german_logo.setPixmap(image)
    german_logo.setAlignment(QtCore.Qt.AlignCenter)
    german_logo.setStyleSheet("margin-top: 1px;")
    Widgets["german_logo"].append(german_logo)
    grid.addWidget(Widgets["german_logo"][-1], 1, 1, 1, 1)

    italian_btn = QPushButton("Italian")
    italian_btn.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    italian_btn.setFixedWidth(800)
    italian_btn.setStyleSheet("*{border: 4px solid '#C84A6B';"
                              + "border-radius: 15px;" +
                              "font-size: 25px;" +
                              "color: 'black';" +
                              "padding: 15px 0;" +
                              "margin: 25px 150px;}" +
                              "*:hover{background:'#C84A6B';}")
    image = QPixmap("italy_flag.png")
    italian_logo = QLabel()
    italian_logo.setPixmap(image)
    italian_logo.setAlignment(QtCore.Qt.AlignCenter)
    italian_logo.setStyleSheet("margin-top: 1px;")
    Widgets["italian_logo"].append(italian_logo)
    grid.addWidget(Widgets["italian_logo"][-1], 2, 2, 1, 1)

    Widgets["italianbutt"].append(italian_btn)
    grid.addWidget(Widgets["italianbutt"][-1], 2, 0, 1, 1)
    italian_btn.clicked.connect(italian_phrases1)

    spanish_btn = QPushButton("Spanish")
    spanish_btn.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    spanish_btn.setFixedWidth(800)
    spanish_btn.setStyleSheet("*{border: 4px solid '#C84A6B';"
                              + "border-radius: 15px;" +
                              "font-size: 25px;" +
                              "color: 'black';" +
                              "padding: 15px 0;" +
                              "margin: 25px 150px;}" +
                              "*:hover{background:'#C84A6B';}")
    image = QPixmap("spain_flag.png")
    spanish_logo = QLabel()
    spanish_logo.setPixmap(image)
    spanish_logo.setAlignment(QtCore.Qt.AlignCenter)
    spanish_logo.setStyleSheet("margin-top: 1px;")
    Widgets["spanish_logo"].append(spanish_logo)
    grid.addWidget(Widgets["spanish_logo"][-1], 3, 1, 1, 1)

    Widgets["spanishbutt"].append(spanish_btn)
    grid.addWidget(Widgets["spanishbutt"][-1], 3, 0, 1, 1)
    spanish_btn.clicked.connect(spanish_phrases1)

    french_btn = QPushButton("French")
    french_btn.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    french_btn.setFixedWidth(800)
    french_btn.setStyleSheet("*{border: 4px solid '#C84A6B';"
                             + "border-radius: 15px;" +
                             "font-size: 25px;" +
                             "color: 'black';" +
                             "padding: 15px 0;" +
                             "margin: 25px 150px;}" +
                             "*:hover{background:'#C84A6B';}")
    image = QPixmap("france_flag.png")
    french_logo = QLabel()
    french_logo.setPixmap(image)
    french_logo.setAlignment(QtCore.Qt.AlignCenter)
    french_logo.setStyleSheet("margin-top: 1px;")
    Widgets["french_logo"].append(french_logo)
    grid.addWidget(Widgets["french_logo"][-1], 4, 2, 1, 1)

    Widgets["frenchbutt"].append(french_btn)
    grid.addWidget(Widgets["frenchbutt"][-1], 4, 0, 1, 1)
    french_btn.clicked.connect(french_frame1)

    portuguese_btn = QPushButton("Portuguese")
    portuguese_btn.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    portuguese_btn.setFixedWidth(800)
    portuguese_btn.setStyleSheet("*{border: 4px solid '#C84A6B';"
                                 + "border-radius: 15px;" +
                                 "font-size: 25px;" +
                                 "color: 'black';" +
                                 "padding: 15px 0;" +
                                 "margin: 25px 150px;}" +
                                 "*:hover{background:'#C84A6B';}")
    image = QPixmap("portugal_flag.png")
    portuguese_logo = QLabel()
    portuguese_logo.setPixmap(image)
    portuguese_logo.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_logo.setStyleSheet("margin-top: 1px;")
    Widgets["portuguese_logo"].append(portuguese_logo)
    grid.addWidget(Widgets["portuguese_logo"][-1], 5, 1, 1, 1)

    Widgets["portuguesebutt"].append(portuguese_btn)
    grid.addWidget(Widgets["portuguesebutt"][-1], 5, 0, 1, 1)
    portuguese_btn.clicked.connect(portuguese_frame1)

    typeInText_btn = QPushButton("Custom text Translate")
    typeInText_btn.setCursor(QCursor(QtCore.Qt.PointingHandCursor))
    typeInText_btn.setFixedWidth(800)
    typeInText_btn.setStyleSheet("*{border: 4px solid '#C84A6B';"
                                 + "border-radius: 17px;" +
                                 "font-size: 25px;" +
                                 "color: 'black';" +
                                 "padding: 15px 0;" +
                                 "margin: 25px 150px;}" +
                                 "*:hover{background:'#C84A6B';}")

    Widgets["lang_buttons"].append(typeInText_btn)
    grid.addWidget(Widgets["lang_buttons"][-1], 6, 0, 1, 1)
    typeInText_btn.clicked.connect(uni_trans)

    back_button = create_buttons("Back")
    Widgets["other_buttons"].append(back_button)
    grid.addWidget(Widgets["other_buttons"][-1], 6, 2)

    back_button.clicked.connect(frame1)

# Language frames
def german_frame1():
    clear_widgets()

    hellogoodbye_gbtn = create_buttons("Hello/Goodbye")
    Widgets["german_buttons"].append(hellogoodbye_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 1, 0, 1, 1)
    hellogoodbye_gbtn.clicked.connect(hello_german_translated)

    sayhello_g = create_voicebtns()
    Voice["voice_buttons"].append(sayhello_g) 
    grid.addWidget(Voice["voice_buttons"][-1],1,2,1,1)
    sayhello_g.clicked.connect(voice_hello_g)
    
    howareyou_gbtn = create_buttons("How are you?")
    Widgets["german_buttons"].append(howareyou_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 2, 0, 1, 1)
    howareyou_gbtn.clicked.connect(howareyou_german_translated)

    sayhowareyou_g = create_voicebtns()
    Voice["voice_buttons"].append(sayhowareyou_g) 
    grid.addWidget(Voice["voice_buttons"][-1],2,2,1,1)
    sayhowareyou_g.clicked.connect(voice_howareyou_g)

    goodnight_gbtn = create_buttons("Good Night/Good Morning")
    Widgets["german_buttons"].append(goodnight_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 3, 0, 1, 1)
    goodnight_gbtn.clicked.connect(goodmorning_german_translated)

    saygoodnight_g = create_voicebtns()
    Voice["voice_buttons"].append(saygoodnight_g) 
    grid.addWidget(Voice["voice_buttons"][-1],3,2,1,1)
    saygoodnight_g.clicked.connect(voice_goodnight_g)

    thankyou_gbtn = create_buttons("Thank You")
    Widgets["german_buttons"].append(thankyou_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 4, 0, 1, 1)
    thankyou_gbtn.clicked.connect(thankyou_german_translated)

    saythankyou_g = create_voicebtns()
    Voice["voice_buttons"].append(saythankyou_g) 
    grid.addWidget(Voice["voice_buttons"][-1],4,2,1,1)
    saythankyou_g.clicked.connect(voice_thankyou_g)

    canyouhelpmewiththis_gbtn = create_buttons("Can you help me with this?")
    Widgets["german_buttons"].append(canyouhelpmewiththis_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 5, 0, 1, 1)
    canyouhelpmewiththis_gbtn.clicked.connect(canyouhelpmewith_german_translated)

    saycanyouhelpmewiththis_g = create_voicebtns()
    Voice["voice_buttons"].append(saycanyouhelpmewiththis_g) 
    grid.addWidget(Voice["voice_buttons"][-1],5,2,1,1)
    saycanyouhelpmewiththis_g.clicked.connect(voice_canyouhelpmewiththis_g)

    next_gbtn = create_buttons("Next")
    Widgets["german_buttons"].append(next_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 6, 1, 1, 1)
    next_gbtn.clicked.connect(german_frame2)

def german_frame2():
    for i in range(0, len(Widgets["german_buttons"])):
        Widgets["german_buttons"][i].hide()
    clear_widgets()
    
    sorry_gbtn = create_buttons("Sorry")
    Widgets["german_buttons"].append(sorry_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 1, 0, 1, 1)
    sorry_gbtn.clicked.connect(sorry_german_translated)

    saysorry_g = create_voicebtns()
    Voice["voice_buttons"].append(saysorry_g) 
    grid.addWidget(Voice["voice_buttons"][-1],1,2,1,1)
    saysorry_g.clicked.connect(voice_sorry_g)

    canihavesomewater_gbtn = create_buttons("Can I have some water?")
    Widgets["german_buttons"].append(canihavesomewater_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 2, 0, 1, 1)
    canihavesomewater_gbtn.clicked.connect(mayihavesomewater_german_translated)

    saycanihavesomewater_g = create_voicebtns()
    Voice["voice_buttons"].append(saycanihavesomewater_g) 
    grid.addWidget(Voice["voice_buttons"][-1],2,2,1,1)
    saycanihavesomewater_g.clicked.connect(voice_canihavesomewater_g)


    yesno_gbtn = create_buttons("Yes / No")
    Widgets["german_buttons"].append(yesno_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 3, 0, 1, 1)
    yesno_gbtn.clicked.connect(yesno_german_translated)

    sayyesno_g = create_voicebtns()
    Voice["voice_buttons"].append(sayyesno_g) 
    grid.addWidget(Voice["voice_buttons"][-1],3,2,1,1)
    sayyesno_g.clicked.connect(voice_yesno_g)

    whereareyoufrom_gbtn = create_buttons("Where are you from?")
    Widgets["german_buttons"].append(whereareyoufrom_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 4, 0, 1, 1)
    whereareyoufrom_gbtn.clicked.connect(whereareyoufrom_german_translated)

    saywhereareyoufrom_g = create_voicebtns()
    Voice["voice_buttons"].append(saywhereareyoufrom_g) 
    grid.addWidget(Voice["voice_buttons"][-1],4,2,1,1)
    saywhereareyoufrom_g.clicked.connect(voice_whereareyoufrom_g)

    excuseme_btn = create_buttons("Excuse me")
    Widgets["german_buttons"].append(excuseme_btn)
    grid.addWidget(Widgets["german_buttons"][-1], 5, 0, 1, 1)
    excuseme_btn.clicked.connect(excuseme_german_translated)

    sayexcuseme_g = create_voicebtns()
    Voice["voice_buttons"].append(sayexcuseme_g ) 
    grid.addWidget(Voice["voice_buttons"][-1],5,2,1,1)
    sayexcuseme_g .clicked.connect(voice_excuseme_g )

    exit_gbtn = create_buttons("Exit")
    Widgets["german_buttons"].append(exit_gbtn)
    grid.addWidget(Widgets["german_buttons"][-1], 6, 1, 1, 1)
    exit_gbtn.clicked.connect(frame2)

    '''frame1test_btn = create_buttons("go back to start")
    Widgets["other_buttons"].append(frame1test_btn)
    grid.addWidget(Widgets["other_buttons"][-1], 6, 0, 1, 1)
    frame1test_btn.clicked.connect(frame1)'''

def italian_phrases1():
    clear_widgets()

    hellogoodbye_btn = create_buttons("Hello/Goodbye")
    Widgets["italian_buttons"].append(hellogoodbye_btn)
    grid.addWidget(Widgets["italian_buttons"][-1], 1, 0, 1, 1)
    hellogoodbye_btn.clicked.connect(hello_italian_translated)

    sayhello_i = create_voicebtns()
    Voice["voice_buttons"].append(sayhello_i)
    grid.addWidget(Voice["voice_buttons"][-1], 1, 2, 1, 1)
    sayhello_i.clicked.connect(voice_hello_i)

    howareyou_btn = create_buttons("How are you?")
    Widgets["italian_buttons"].append(howareyou_btn)
    grid.addWidget(Widgets["italian_buttons"][-1], 2, 0, 1, 1)
    howareyou_btn.clicked.connect(howareyou_italian_translated)

    sayhowareyou_i = create_voicebtns()
    Voice["voice_buttons"].append(sayhowareyou_i)
    grid.addWidget(Voice["voice_buttons"][-1], 2, 2, 1, 1)
    sayhowareyou_i.clicked.connect(voice_howareyou_i)

    goodnight_btn = create_buttons("Good Morning/Night")
    Widgets["italian_buttons"].append(goodnight_btn)
    grid.addWidget(Widgets["italian_buttons"][-1], 3, 0, 1, 1)
    goodnight_btn.clicked.connect(goodnight_i)

    saygoodnight_i = create_voicebtns()
    Voice["voice_buttons"].append(saygoodnight_i)
    grid.addWidget(Voice["voice_buttons"][-1], 3, 2, 1, 1)
    saygoodnight_i.clicked.connect(voice_goodnight_i)

    thankyou_btn = create_buttons("Thank You")
    Widgets["italian_buttons"].append(thankyou_btn)
    grid.addWidget(Widgets["italian_buttons"][-1], 4, 0, 1, 1)
    thankyou_btn.clicked.connect(thankyou_i)

    saythankyou_i = create_voicebtns()
    Voice["voice_buttons"].append(saythankyou_i)
    grid.addWidget(Voice["voice_buttons"][-1], 4, 2, 1, 1)
    saythankyou_i.clicked.connect(voice_thankyou_i)

    canyouhelpmewiththis_ibtn = create_buttons("Can you help me with this?")
    Widgets["italian_buttons"].append(canyouhelpmewiththis_ibtn)
    grid.addWidget(Widgets["italian_buttons"][-1], 5, 0, 1, 1)
    canyouhelpmewiththis_ibtn.clicked.connect(canyouhelpmewiththis_i)

    saycanyouhelpmewiththis_i = create_voicebtns()
    Voice["voice_buttons"].append(saycanyouhelpmewiththis_i)
    grid.addWidget(Voice["voice_buttons"][-1], 5, 2, 1, 1)
    saycanyouhelpmewiththis_i.clicked.connect(voice_canyouhelpmewiththis_i)

    name_ibtn = create_buttons("What is your name?")
    Widgets["italian_buttons"].append(name_ibtn)
    grid.addWidget(Widgets["italian_buttons"][-1], 6, 0, 1, 1)
    name_ibtn.clicked.connect(name_i)

    sayname_i = create_voicebtns()
    Voice["voice_buttons"].append(sayname_i)
    grid.addWidget(Voice["voice_buttons"][-1], 6, 2, 1, 1)
    sayname_i.clicked.connect(voice_name_i)

    next_ibtn = create_buttons("Next")
    Widgets["italian_buttons"].append(next_ibtn)
    grid.addWidget(Widgets["italian_buttons"][-1], 7, 1, 1, 1)
    next_ibtn.clicked.connect(italian_frame2)

def italian_frame2():
    for i in range(0, len(Widgets["italian_buttons"])):
        Widgets["italian_buttons"][i].hide()
    clear_widgets()

    sorry_btn = create_buttons("Sorry")
    Widgets["italian_buttons"].append(sorry_btn)
    grid.addWidget(Widgets["italian_buttons"][-1], 1, 0, 1, 1)
    sorry_btn.clicked.connect(sorry_i)

    saysorry_i = create_voicebtns()
    Voice["voice_buttons"].append(saysorry_i)
    grid.addWidget(Voice["voice_buttons"][-1], 1, 2, 1, 1)
    saysorry_i.clicked.connect(voice_sorry_i)

    canihavesomewater_btn = create_buttons("Can I have some water?")
    Widgets["italian_buttons"].append(canihavesomewater_btn)
    grid.addWidget(Widgets["italian_buttons"][-1], 2, 0, 1, 1)
    canihavesomewater_btn.clicked.connect(canihavesomewater_i)

    saycanihavesomewater_i = create_voicebtns()
    Voice["voice_buttons"].append(saycanihavesomewater_i)
    grid.addWidget(Voice["voice_buttons"][-1], 2, 2, 1, 1)
    saycanihavesomewater_i.clicked.connect(voice_canihavesomewater_i)

    yesno_btn = create_buttons("Yes/No")
    Widgets["italian_buttons"].append(yesno_btn)
    grid.addWidget(Widgets["italian_buttons"][-1], 3, 0, 1, 1)
    yesno_btn.clicked.connect(yesno_i)

    sayyesno_i = create_voicebtns()
    Voice["voice_buttons"].append(sayyesno_i)
    grid.addWidget(Voice["voice_buttons"][-1], 3, 2, 1, 1)
    sayyesno_i.clicked.connect(voice_yesno_i)

    whereareyoufrom_btn = create_buttons("Where are you from?")
    Widgets["italian_buttons"].append(whereareyoufrom_btn)
    grid.addWidget(Widgets["italian_buttons"][-1], 4, 0, 1, 1)
    whereareyoufrom_btn.clicked.connect(whereareyoufrom_i)

    saywhereareyoufrom_i = create_voicebtns()
    Voice["voice_buttons"].append(saywhereareyoufrom_i)
    grid.addWidget(Voice["voice_buttons"][-1], 4, 2, 1, 1)
    saywhereareyoufrom_i.clicked.connect(voice_whereareyoufrom_i)

    excuseme_btn = create_buttons("Excuse me")
    Widgets["italian_buttons"].append(excuseme_btn)
    grid.addWidget(Widgets["italian_buttons"][-1], 5, 0, 1, 1)
    excuseme_btn.clicked.connect(excuseme_i)

    sayexcuseme_i = create_voicebtns()
    Voice["voice_buttons"].append(sayexcuseme_i)
    grid.addWidget(Voice["voice_buttons"][-1], 5, 2, 1, 1)
    sayexcuseme_i.clicked.connect(voice_excuseme_i)

    exit_ibtn = create_buttons("Exit")
    Widgets["italian_buttons"].append(exit_ibtn)
    grid.addWidget(Widgets["italian_buttons"][-1], 6, 1, 1, 1)
    exit_ibtn.clicked.connect(frame2)

def spanish_phrases1():
    clear_widgets()

    hello_sbtn = create_buttons("Hello / Goodbye")
    Widgets["spanish_buttons"].append(hello_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 1, 0, 1, 1)
    hello_sbtn.clicked.connect(hello_s)

    sayhello_s = create_voicebtns()
    Voice["voice_buttons"].append(sayhello_s) 
    grid.addWidget(Voice["voice_buttons"][-1],1,2,1,1)
    sayhello_s.clicked.connect(voice_hello_s)

    sorry_sbtn = create_buttons("Sorry")
    Widgets["spanish_buttons"].append(sorry_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 2, 0, 1, 1)
    sorry_sbtn.clicked.connect(sorry_s)

    saysorry_s = create_voicebtns()
    Voice["voice_buttons"].append(saysorry_s) 
    grid.addWidget(Voice["voice_buttons"][-1],2,2,1,1)
    saysorry_s.clicked.connect(voice_sorry_s)

    thankyou_sbtn = create_buttons("Thank you!")
    Widgets["spanish_buttons"].append(thankyou_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 3, 0, 1, 1)
    thankyou_sbtn.clicked.connect(thankyou_s)

    saythankyou_s = create_voicebtns()
    Voice["voice_buttons"].append(saythankyou_s) 
    grid.addWidget(Voice["voice_buttons"][-1],3,2,1,1)
    saythankyou_s.clicked.connect(voice_thankyou_s)

    gm_sbtn = create_buttons("Good Morning/Night")
    Widgets["spanish_buttons"].append(gm_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 4, 0, 1, 1)
    gm_sbtn.clicked.connect(gm_s)

    saygm_s = create_voicebtns()
    Voice["voice_buttons"].append(saygm_s) 
    grid.addWidget(Voice["voice_buttons"][-1],4,2,1,1)
    saygm_s.clicked.connect(voice_gm_s)

    howareyou_sbtn = create_buttons("How are you? / I am fine.")
    Widgets["spanish_buttons"].append(howareyou_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 5, 0, 1, 1)
    howareyou_sbtn.clicked.connect(howareyou_s)

    sayhowareyou_s = create_voicebtns()
    Voice["voice_buttons"].append(sayhowareyou_s) 
    grid.addWidget(Voice["voice_buttons"][-1],5,2,1,1)
    sayhowareyou_s.clicked.connect(voice_howareyou_s)

    canyouhelp_sbtn = create_buttons("Can you help me with ______")
    Widgets["spanish_buttons"].append(canyouhelp_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 6, 0, 1, 1)
    canyouhelp_sbtn.clicked.connect(canyouhelp_s)

    saycanyouhelp_s = create_voicebtns()
    Voice["voice_buttons"].append(saycanyouhelp_s) 
    grid.addWidget(Voice["voice_buttons"][-1],6,2,1,1)
    saycanyouhelp_s.clicked.connect(voice_canyouhelp_s)

    next_sbtn = create_buttons("Next")
    Widgets["spanish_buttons"].append(next_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 7, 1, 1, 1)
    next_sbtn.clicked.connect(spanish_phrases2)

def spanish_phrases2():
    for i in range(0, len(Widgets["spanish_buttons"])):
        Widgets["spanish_buttons"][i].hide()
    clear_widgets()

    mayihave_sbtn = create_buttons("May I have some water?")
    Widgets["spanish_buttons"].append(mayihave_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 1, 0, 1, 1)
    mayihave_sbtn.clicked.connect(mayihave_s)

    saymayihave_s = create_voicebtns()
    Voice["voice_buttons"].append(saymayihave_s) 
    grid.addWidget(Voice["voice_buttons"][-1],1,2,1,1)
    saymayihave_s.clicked.connect(voice_mayihave_s)

    yesno_sbtn = create_buttons("Yes/No")
    Widgets["spanish_buttons"].append(yesno_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 2, 0, 1, 1)
    yesno_sbtn.clicked.connect(yesno_s)

    sayyesno_s = create_voicebtns()
    Voice["voice_buttons"].append(sayyesno_s) 
    grid.addWidget(Voice["voice_buttons"][-1],2,2,1,1)
    sayyesno_s.clicked.connect(voice_yesno_s)

    whereareyoufrom_sbtn = create_buttons("Where are you from?")
    Widgets["spanish_buttons"].append(whereareyoufrom_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 3, 0, 1, 1)
    whereareyoufrom_sbtn.clicked.connect(whereareyoufrom_s)

    saywhereareyoufrom_s = create_voicebtns()
    Voice["voice_buttons"].append(saywhereareyoufrom_s) 
    grid.addWidget(Voice["voice_buttons"][-1],3,2,1,1)
    saywhereareyoufrom_s.clicked.connect(voice_whereareyoufrom_s)

    excuseme_sbtn = create_buttons("Excuse me.")
    Widgets["spanish_buttons"].append(excuseme_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 4, 0, 1, 1)
    excuseme_sbtn.clicked.connect(excuseme_s)

    sayexcuseme_s = create_voicebtns()
    Voice["voice_buttons"].append(sayexcuseme_s) 
    grid.addWidget(Voice["voice_buttons"][-1],4,2,1,1)
    sayexcuseme_s.clicked.connect(voice_excuseme_s)

    name_sbtn = create_buttons("What is your name? / My name is _____")
    Widgets["spanish_buttons"].append(name_sbtn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 5, 0, 1, 1)
    name_sbtn.clicked.connect(name_s)

    sayname_s = create_voicebtns()
    Voice["voice_buttons"].append(sayname_s) 
    grid.addWidget(Voice["voice_buttons"][-1],5,2,1,1)
    sayname_s.clicked.connect(voice_name_s)

    exit_btn = create_buttons("Exit")
    Widgets["spanish_buttons"].append(exit_btn)
    grid.addWidget(Widgets["spanish_buttons"][-1], 6, 1, 1, 1)
    exit_btn.clicked.connect(frame2)

def french_frame1():
    clear_widgets()

    hellogoodbye_btn = create_buttons("Hello/Goodbye")
    Widgets["french_buttons"].append(hellogoodbye_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 1, 0, 1, 1)
    hellogoodbye_btn.clicked.connect(hello_french_translated)

    sayhellogoodbye_f = create_voicebtns()
    Voice["voice_buttons"].append(sayhellogoodbye_f) 
    grid.addWidget(Voice["voice_buttons"][-1],1,2,1,1)
    sayhellogoodbye_f.clicked.connect(voice_hellogoodbye_f)

    howareyou_btn = create_buttons("How are you?")
    Widgets["french_buttons"].append(howareyou_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 2, 0, 1, 1)
    howareyou_btn.clicked.connect(howareyou_french_translated)

    sayhowareyou_f = create_voicebtns()
    Voice["voice_buttons"].append(sayhowareyou_f) 
    grid.addWidget(Voice["voice_buttons"][-1],2,2,1,1)
    sayhowareyou_f.clicked.connect(voice_howareyou_f)

    goodnight_btn = create_buttons("Good Morning/Good Night")
    Widgets["french_buttons"].append(goodnight_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 3, 0, 1, 1)
    goodnight_btn.clicked.connect(goodnight_f)

    saygoodnight_f = create_voicebtns()
    Voice["voice_buttons"].append(saygoodnight_f) 
    grid.addWidget(Voice["voice_buttons"][-1],3,2,1,1)
    saygoodnight_f.clicked.connect(voice_goodnight_f)

    thankyou_btn = create_buttons("Thank You")
    Widgets["french_buttons"].append(thankyou_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 4, 0, 1, 1)
    thankyou_btn.clicked.connect(thankyou_f)

    saythankyou_f = create_voicebtns()
    Voice["voice_buttons"].append(saythankyou_f) 
    grid.addWidget(Voice["voice_buttons"][-1],4,2,1,1)
    saythankyou_f.clicked.connect(voice_thankyou_f)

    canyouhelpmewiththis_btn = create_buttons("Can you help me with this?")
    Widgets["french_buttons"].append(canyouhelpmewiththis_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 5, 0, 1, 1)
    canyouhelpmewiththis_btn.clicked.connect(canyouhelpmewiththis_f)

    saycanyouhelpmewiththis_f = create_voicebtns()
    Voice["voice_buttons"].append(saycanyouhelpmewiththis_f) 
    grid.addWidget(Voice["voice_buttons"][-1],5,2,1,1)
    saycanyouhelpmewiththis_f.clicked.connect(voice_canyouhelpmewiththis_f)

    next_btn = create_buttons("Next")
    Widgets["french_buttons"].append(next_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 6, 1, 1, 1)
    next_btn.clicked.connect(french_frame2)

def french_frame2():
    for i in range(0, len(Widgets["french_buttons"])):
        Widgets["french_buttons"][i].hide()
    
    clear_widgets()

    sorry_btn = create_buttons("Sorry")
    Widgets["french_buttons"].append(sorry_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 1, 0, 1, 1)
    sorry_btn.clicked.connect(sorry_f)

    saysorry_f = create_voicebtns()
    Voice["voice_buttons"].append(saysorry_f) 
    grid.addWidget(Voice["voice_buttons"][-1],1,2,1,1)
    saysorry_f.clicked.connect(voice_sorry_f)

    canihavesomewater_btn = create_buttons("Can I have some water?")
    Widgets["french_buttons"].append(canihavesomewater_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 2, 0, 1, 1)
    canihavesomewater_btn.clicked.connect(canihavesomewater_f)

    saycanihavesomewater_f = create_voicebtns()
    Voice["voice_buttons"].append(saycanihavesomewater_f) 
    grid.addWidget(Voice["voice_buttons"][-1],2,2,1,1)
    saycanihavesomewater_f.clicked.connect(voice_canihavesomewater_f)

    yesno_btn = create_buttons("Yes/No")
    Widgets["french_buttons"].append(yesno_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 3, 0, 1, 1)
    yesno_btn.clicked.connect(yesno_f)

    sayyesno_f = create_voicebtns()
    Voice["voice_buttons"].append(sayyesno_f) 
    grid.addWidget(Voice["voice_buttons"][-1],3,2,1,1)
    sayyesno_f.clicked.connect(voice_yesno_f)

    whereareyoufrom_btn = create_buttons("Where are you from?")
    Widgets["french_buttons"].append(whereareyoufrom_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 4, 0, 1, 1)
    whereareyoufrom_btn.clicked.connect(whereareyoufrom_f)

    saywhereareyoufrom_f = create_voicebtns()
    Voice["voice_buttons"].append(saywhereareyoufrom_f) 
    grid.addWidget(Voice["voice_buttons"][-1],4,2,1,1)
    saywhereareyoufrom_f.clicked.connect(voice_whereareyoufrom_f)

    excuseme_btn = create_buttons("Excuse me")
    Widgets["french_buttons"].append(excuseme_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 5, 0, 1, 1)
    excuseme_btn.clicked.connect(excuseme_f)

    sayexcuseme_f = create_voicebtns()
    Voice["voice_buttons"].append(sayexcuseme_f) 
    grid.addWidget(Voice["voice_buttons"][-1],5,2,1,1)
    sayexcuseme_f.clicked.connect(voice_excuseme_f)

    exit_btn = create_buttons("Exit")
    Widgets["french_buttons"].append(exit_btn)
    grid.addWidget(Widgets["french_buttons"][-1], 6, 1, 1, 1)
    exit_btn.clicked.connect(frame2)

def portuguese_frame1():
    clear_widgets()

    hellogoodbye_btn = create_buttons("Hello/Goodbye")
    Widgets["portuguese_buttons"].append(hellogoodbye_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 1, 0, 1, 1)
    hellogoodbye_btn.clicked.connect(hello_portuguese_translated)

    sayhellogoodbye_p = create_voicebtns()
    Voice["voice_buttons"].append(sayhellogoodbye_p) 
    grid.addWidget(Voice["voice_buttons"][-1],1,2,1,1)
    sayhellogoodbye_p.clicked.connect(voice_hellogoodbye_p)

    howareyou_btn = create_buttons("How are you?")
    Widgets["portuguese_buttons"].append(howareyou_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 2, 0, 1, 1)
    howareyou_btn.clicked.connect(howareyou_portuguese_translated)

    sayhowareyou_p = create_voicebtns()
    Voice["voice_buttons"].append(sayhowareyou_p) 
    grid.addWidget(Voice["voice_buttons"][-1],2,2,1,1)
    sayhowareyou_p.clicked.connect(voice_howareyou_p)

    goodnight_btn = create_buttons("Good Morning/Good Night")
    Widgets["portuguese_buttons"].append(goodnight_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 3, 0, 1, 1)
    goodnight_btn.clicked.connect(goodnight_p)

    saygoodnight_p = create_voicebtns()
    Voice["voice_buttons"].append(saygoodnight_p) 
    grid.addWidget(Voice["voice_buttons"][-1],3,2,1,1)
    saygoodnight_p.clicked.connect(voice_goodnight_p)

    thankyou_btn = create_buttons("Thank You")
    Widgets["portuguese_buttons"].append(thankyou_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 4, 0, 1, 1)
    thankyou_btn.clicked.connect(thankyou_p)

    saythankyou_p = create_voicebtns()
    Voice["voice_buttons"].append(saythankyou_p) 
    grid.addWidget(Voice["voice_buttons"][-1],4,2,1,1)
    saythankyou_p.clicked.connect(voice_thankyou_p)

    canyouhelpmewiththis_btn = create_buttons("Can you help me with this?")
    Widgets["portuguese_buttons"].append(canyouhelpmewiththis_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 5, 0, 1, 1)
    canyouhelpmewiththis_btn.clicked.connect(canyouhelpmewiththis_p)

    saycanyouhelpmewiththis_p = create_voicebtns()
    Voice["voice_buttons"].append(saycanyouhelpmewiththis_p) 
    grid.addWidget(Voice["voice_buttons"][-1],5,2,1,1)
    saycanyouhelpmewiththis_p.clicked.connect(voice_canyouhelpmewiththis_p)

    next_btn = create_buttons("Next")
    Widgets["portuguese_buttons"].append(next_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 6, 1, 1, 1)
    next_btn.clicked.connect(portuguese_frame2)

def portuguese_frame2():
    for i in range(0, len(Widgets["portuguese_buttons"])):
        Widgets["portuguese_buttons"][i].hide()
    clear_widgets()

    sorry_btn = create_buttons("Sorry")
    Widgets["portuguese_buttons"].append(sorry_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 1, 0, 1, 1)
    sorry_btn.clicked.connect(sorry_p)

    saysorry_p = create_voicebtns()
    Voice["voice_buttons"].append(saysorry_p) 
    grid.addWidget(Voice["voice_buttons"][-1],1,2,1,1)
    saysorry_p.clicked.connect(voice_sorry_p)

    canihavesomewater_btn = create_buttons("Can I have some water?")
    Widgets["portuguese_buttons"].append(canihavesomewater_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 2, 0, 1, 1)
    canihavesomewater_btn.clicked.connect(canihavesomewater_p)

    saycanihavesomewater_p = create_voicebtns()
    Voice["voice_buttons"].append(saycanihavesomewater_p) 
    grid.addWidget(Voice["voice_buttons"][-1],2,2,1,1)
    saycanihavesomewater_p.clicked.connect(voice_canihavesomewater_p)

    yesno_btn = create_buttons("Yes / No")
    Widgets["portuguese_buttons"].append(yesno_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 3, 0, 1, 1)
    yesno_btn.clicked.connect(yesno_p)

    sayyesno_p = create_voicebtns()
    Voice["voice_buttons"].append(sayyesno_p) 
    grid.addWidget(Voice["voice_buttons"][-1],3,2,1,1)
    sayyesno_p.clicked.connect(voice_yesno_p)

    whereareyoufrom_btn = create_buttons("Where are you from?")
    Widgets["portuguese_buttons"].append(whereareyoufrom_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 4, 0, 1, 1)
    whereareyoufrom_btn.clicked.connect(whereareyoufrom_p)

    saywhereareyoufrom_p = create_voicebtns()
    Voice["voice_buttons"].append(saywhereareyoufrom_p) 
    grid.addWidget(Voice["voice_buttons"][-1],4,2,1,1)
    saywhereareyoufrom_p.clicked.connect(voice_whereareyoufrom_p)

    excuseme_btn = create_buttons("Excuse me")
    Widgets["portuguese_buttons"].append(excuseme_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 5, 0, 1, 1)
    excuseme_btn.clicked.connect(excuseme_p)

    sayexcuseme_p = create_voicebtns()
    Voice["voice_buttons"].append(sayexcuseme_p) 
    grid.addWidget(Voice["voice_buttons"][-1],5,2,1,1)
    sayexcuseme_p.clicked.connect(voice_excuseme_p)

    exit_btn = create_buttons("Exit")
    Widgets["portuguese_buttons"].append(exit_btn)
    grid.addWidget(Widgets["portuguese_buttons"][-1], 6, 1, 1, 1)
    exit_btn.clicked.connect(frame2)

# Quiz Frames
# German
def german_question1():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    german_q1 = QLabel("How many official languages are there in Germany?")
    german_q1.setAlignment(QtCore.Qt.AlignCenter)
    german_q1.setWordWrap(True)
    german_q1.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    german_q1.setFixedHeight(200)
    Labels["german_ques"].append(german_q1)

    gopt1 = create_buttons("12")
    gopt2 = create_buttons("9")
    gopt3 = create_buttons("45")
    gopt4 = create_buttons("2")
    next_button = create_buttons("Next")

    Widgets["germanopt1"].append(gopt1)
    Widgets["germanopt2"].append(gopt2)
    Widgets["germanopt3"].append(gopt3)
    Widgets["germanopt4"].append(gopt4)
    grid.addWidget(Labels["german_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["germanopt1"][-1], 2, 0)
    gopt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt2"][-1], 2, 1)
    gopt2.clicked.connect(correct_ans)
    grid.addWidget(Widgets["germanopt3"][-1], 3, 0)
    gopt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt4"][-1], 3, 1)
    gopt4.clicked.connect(wrong_ans)

    image = QPixmap("gq1.jpg")
    german_logo = QLabel()
    german_logo.setPixmap(image)
    german_logo.setAlignment(QtCore.Qt.AlignCenter)
    german_logo.setStyleSheet("margin-top: 1px;")
    Widgets["german_logo"].append(german_logo)
    grid.addWidget(Widgets["german_logo"][-1],1,2,1,1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(german_question2)

def german_question2():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    german_q2 = QLabel("What is the name of Germany in the German language?")
    german_q2.setAlignment(QtCore.Qt.AlignCenter)
    german_q2.setWordWrap(True)
    german_q2.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    german_q2.setFixedHeight(200)
    Labels["german_ques"].append(german_q2)

    g2opt1 = create_buttons("Allemagne")
    g2opt2 = create_buttons("Niemcy")
    g2opt3 = create_buttons("Deutschland")
    g2opt4 = create_buttons("Germany")
    next_button = create_buttons("Next")

    Widgets["germanopt1"].append(g2opt1)
    Widgets["germanopt2"].append(g2opt2)
    Widgets["germanopt3"].append(g2opt3)
    Widgets["germanopt4"].append(g2opt4)
    grid.addWidget(Labels["german_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["germanopt1"][-1], 2, 0)
    g2opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt2"][-1], 2, 1)
    g2opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt3"][-1], 3, 0)
    g2opt3.clicked.connect(correct_ans)
    grid.addWidget(Widgets["germanopt4"][-1], 3, 1)
    g2opt4.clicked.connect(wrong_ans)

    image = QPixmap("gq2.jpg")
    german_logo = QLabel()
    german_logo.setPixmap(image)
    german_logo.setAlignment(QtCore.Qt.AlignCenter)
    german_logo.setStyleSheet("margin-top: 1px;")
    Widgets["german_logo"].append(german_logo)
    grid.addWidget(Widgets["german_logo"][-1],1,2,1,1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(german_question3)

def german_question3():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    german_q3 = QLabel("How many countries have German as its official language?")
    german_q3.setAlignment(QtCore.Qt.AlignCenter)
    german_q3.setWordWrap(True)
    german_q3.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    german_q3.setFixedHeight(200)
    Labels["german_ques"].append(german_q3)

    g3opt1 = create_buttons("9")
    g3opt2 = create_buttons("1")
    g3opt3 = create_buttons("12")
    g3opt4 = create_buttons("6")
    next_button = create_buttons("Next")

    Widgets["germanopt1"].append(g3opt1)
    Widgets["germanopt2"].append(g3opt2)
    Widgets["germanopt3"].append(g3opt3)
    Widgets["germanopt4"].append(g3opt4)
    grid.addWidget(Labels["german_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["germanopt1"][-1], 2, 0)
    g3opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt2"][-1], 2, 1)
    g3opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt3"][-1], 3, 0)
    g3opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt4"][-1], 3, 1)
    g3opt4.clicked.connect(correct_ans)

    image = QPixmap("gq3.jpg")
    german_logo = QLabel()
    german_logo.setPixmap(image)
    german_logo.setAlignment(QtCore.Qt.AlignCenter)
    german_logo.setStyleSheet("margin-top: 1px;")
    Widgets["german_logo"].append(german_logo)
    grid.addWidget(Widgets["german_logo"][-1],1,2,1,1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(german_question4)

def german_question4():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    german_q4 = QLabel("What is the name of the German potato dumplings?")
    german_q4.setAlignment(QtCore.Qt.AlignCenter)
    german_q4.setWordWrap(True)
    german_q4.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    german_q4.setFixedHeight(200)
    Labels["german_ques"].append(german_q4)

    g4opt1 = create_buttons("Kartoffelkloesse")
    g4opt2 = create_buttons("Rouladen")
    g4opt3 = create_buttons("Kartoffelpuffer")
    g4opt4 = create_buttons("Sauerbraten")
    next_button = create_buttons("Next")

    Widgets["germanopt1"].append(g4opt1)
    Widgets["germanopt2"].append(g4opt2)
    Widgets["germanopt3"].append(g4opt3)
    Widgets["germanopt4"].append(g4opt4)
    grid.addWidget(Labels["german_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["germanopt1"][-1], 2, 0)
    g4opt1.clicked.connect(correct_ans)
    grid.addWidget(Widgets["germanopt2"][-1], 2, 1)
    g4opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt3"][-1], 3, 0)
    g4opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt4"][-1], 3, 1)
    g4opt4.clicked.connect(wrong_ans)

    image = QPixmap("gq4.jpg")
    german_logo = QLabel()
    german_logo.setPixmap(image)
    german_logo.setAlignment(QtCore.Qt.AlignCenter)
    german_logo.setStyleSheet("margin-top: 1px;")
    Widgets["german_logo"].append(german_logo)
    grid.addWidget(Widgets["german_logo"][-1],1,2,1,1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(german_question5)

def german_question5():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    german_q5 = QLabel("The German Language has closest relations with ?")
    german_q5.setAlignment(QtCore.Qt.AlignCenter)
    german_q5.setWordWrap(True)
    german_q5.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    german_q5.setFixedHeight(200)
    Labels["german_ques"].append(german_q5)

    g5opt1 = create_buttons("Spanish")
    g5opt2 = create_buttons("Italian")
    g5opt3 = create_buttons("French")
    g5opt4 = create_buttons("English")
    next_button = create_buttons("Next")

    Widgets["germanopt1"].append(g5opt1)
    Widgets["germanopt2"].append(g5opt2)
    Widgets["germanopt3"].append(g5opt3)
    Widgets["germanopt4"].append(g5opt4)
    grid.addWidget(Labels["german_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["germanopt1"][-1], 2, 0)
    g5opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt2"][-1], 2, 1)
    g5opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt3"][-1], 3, 0)
    g5opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["germanopt4"][-1], 3, 1)
    g5opt4.clicked.connect(correct_ans)

    image = QPixmap("gq5.jpg")
    german_logo = QLabel()
    german_logo.setPixmap(image)
    german_logo.setAlignment(QtCore.Qt.AlignCenter)
    german_logo.setStyleSheet("margin-top: 1px;")
    Widgets["german_logo"].append(german_logo)
    grid.addWidget(Widgets["german_logo"][-1],1,2,1,1)

    next_button = create_buttons("End")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)
    next_button.clicked.connect(frame1)

    # Spanish
def spanish_question1():
    clear_widgets()
    spanish_q1 = QLabel("What does \"Lo Siento\" mean in Spanish ?")
    spanish_q1.setAlignment(QtCore.Qt.AlignCenter)
    spanish_q1.setWordWrap(True)
    spanish_q1.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    spanish_q1.setFixedHeight(200)
    Labels["spanish_ques"].append(spanish_q1)

    spanish1opt1 = create_buttons("Sorry")
    spanish1opt2 = create_buttons("Thank you")
    spanish1opt3 = create_buttons("Good bye")
    spanish1opt4 = create_buttons("Hello")
    spanish1opt5 = create_buttons("Next")

    Widgets["soption1"].append(spanish1opt1)
    Widgets["soption2"].append(spanish1opt2)
    Widgets["soption3"].append(spanish1opt3)
    Widgets["soption4"].append(spanish1opt4)
    grid.addWidget(Labels["spanish_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["soption1"][-1], 2, 0)
    spanish1opt1.clicked.connect(correct_ans)
    grid.addWidget(Widgets["soption2"][-1], 2, 1)
    spanish1opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption3"][-1], 3, 0)
    spanish1opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption4"][-1], 3, 1)
    spanish1opt4.clicked.connect(wrong_ans)

    image = QPixmap("sq1.jpg")
    spanish_logo = QLabel()
    spanish_logo.setPixmap(image)
    spanish_logo.setAlignment(QtCore.Qt.AlignCenter)
    spanish_logo.setStyleSheet("margin-top: 1px;")
    Widgets["spanish_logo"].append(spanish_logo)
    grid.addWidget(Widgets["spanish_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(spanish_question2)

def spanish_question2():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    spanish_q2 = QLabel("Spanish is the _______ most spoken language in the world.")
    spanish_q2.setAlignment(QtCore.Qt.AlignCenter)
    spanish_q2.setWordWrap(True)
    spanish_q2.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    spanish_q2.setFixedHeight(200)
    Labels["spanish_ques"].append(spanish_q2)

    spanish3opt1 = create_buttons("First")
    spanish3opt2 = create_buttons("Second")
    spanish3opt3 = create_buttons("Third")
    spanish3opt4 = create_buttons("Fourth")
    next_button = create_buttons("Next")

    Widgets["soption1"].append(spanish3opt1)
    Widgets["soption2"].append(spanish3opt2)
    Widgets["soption3"].append(spanish3opt3)
    Widgets["soption4"].append(spanish3opt4)
    grid.addWidget(Labels["spanish_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["soption1"][-1], 2, 0)

    spanish3opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption2"][-1], 2, 1)
    spanish3opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption3"][-1], 3, 0)
    spanish3opt4.clicked.connect(correct_ans)
    grid.addWidget(Widgets["soption4"][-1], 3, 1)
    spanish3opt3.clicked.connect(wrong_ans)

    image = QPixmap("sq2.jpg")
    spanish_logo = QLabel()
    spanish_logo.setPixmap(image)
    spanish_logo.setAlignment(QtCore.Qt.AlignCenter)
    spanish_logo.setStyleSheet("margin-top: 1px;")
    Widgets["spanish_logo"].append(spanish_logo)
    grid.addWidget(Widgets["spanish_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(spanish_question3)

def spanish_question3():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    spanish_q3 = QLabel("Which country has the most Spanish speakers?")
    spanish_q3.setAlignment(QtCore.Qt.AlignCenter)
    spanish_q3.setWordWrap(True)
    spanish_q3.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    spanish_q3.setFixedHeight(200)
    Labels["spanish_ques"].append(spanish_q3)
    spanish4opt1 = create_buttons("Mexico")
    spanish4opt2 = create_buttons("Columbia")
    spanish4opt3 = create_buttons("Spain")
    spanish4opt4 = create_buttons("Argentina")
    next_button = create_buttons("Next")

    Widgets["soption1"].append(spanish4opt1)
    Widgets["soption2"].append(spanish4opt2)
    Widgets["soption3"].append(spanish4opt3)
    Widgets["soption4"].append(spanish4opt4)
    grid.addWidget(Labels["spanish_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["soption1"][-1], 2, 0)
    spanish4opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption2"][-1], 2, 1)
    spanish4opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption3"][-1], 3, 0)
    spanish4opt1.clicked.connect(correct_ans)
    grid.addWidget(Widgets["soption4"][-1], 3, 1)
    spanish4opt4.clicked.connect(wrong_ans)

    image = QPixmap("sq3.jpg")
    spanish_logo = QLabel()
    spanish_logo.setPixmap(image)
    spanish_logo.setAlignment(QtCore.Qt.AlignCenter)
    spanish_logo.setStyleSheet("margin-top: 1px;")
    Widgets["spanish_logo"].append(spanish_logo)
    grid.addWidget(Widgets["spanish_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)
    next_button.clicked.connect(spanish_question4)

def spanish_question4():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    spanish_q4 = QLabel(
        "Which traditional Spanish dance originated in Andalusia and is recognised by UNESCO as a heritage of humanity?")
    spanish_q4.setAlignment(QtCore.Qt.AlignCenter)
    spanish_q4.setWordWrap(True)
    spanish_q4.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    spanish_q4.setFixedHeight(200)
    Labels["spanish_ques"].append(spanish_q4)
    spanish4opt1 = create_buttons("Sardana")
    spanish4opt2 = create_buttons("Tango")
    spanish4opt3 = create_buttons("Flamenco")
    spanish4opt4 = create_buttons("Paso Doble")
    next_button = create_buttons("Next")

    Widgets["soption1"].append(spanish4opt1)
    Widgets["soption2"].append(spanish4opt2)
    Widgets["soption3"].append(spanish4opt3)
    Widgets["soption4"].append(spanish4opt4)
    grid.addWidget(Labels["spanish_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["soption1"][-1], 2, 0)
    spanish4opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption2"][-1], 2, 1)
    spanish4opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption3"][-1], 3, 0)
    spanish4opt3.clicked.connect(correct_ans)
    grid.addWidget(Widgets["soption4"][-1], 3, 1)
    spanish4opt4.clicked.connect(wrong_ans)

    image = QPixmap("sq4.jpg")
    spanish_logo = QLabel()
    spanish_logo.setPixmap(image)
    spanish_logo.setAlignment(QtCore.Qt.AlignCenter)
    spanish_logo.setStyleSheet("margin-top: 1px;")
    Widgets["spanish_logo"].append(spanish_logo)
    grid.addWidget(Widgets["spanish_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)
    next_button.clicked.connect(spanish_question5)

def spanish_question5():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    spanish_q5 = QLabel(
        "The movie \'COCO\' produced by Pixar Animation Studios represent the culture of which of the following Spanish speaking country?")
    spanish_q5.setAlignment(QtCore.Qt.AlignCenter)
    spanish_q5.setWordWrap(True)
    spanish_q5.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    spanish_q5.setFixedHeight(200)
    Labels["spanish_ques"].append(spanish_q5)
    spanish5opt1 = create_buttons("Spain")
    spanish5opt2 = create_buttons("Mexico")
    spanish5opt3 = create_buttons("Peru")
    spanish5opt4 = create_buttons("Chile")
    next_button = create_buttons("Next")

    Widgets["soption1"].append(spanish5opt1)
    Widgets["soption2"].append(spanish5opt2)
    Widgets["soption3"].append(spanish5opt3)
    Widgets["soption4"].append(spanish5opt4)
    grid.addWidget(Labels["spanish_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["soption1"][-1], 2, 0)
    spanish5opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption2"][-1], 2, 1)
    spanish5opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["soption3"][-1], 3, 0)
    spanish5opt2.clicked.connect(correct_ans)
    grid.addWidget(Widgets["soption4"][-1], 3, 1)
    spanish5opt4.clicked.connect(wrong_ans)

    image = QPixmap("sq5.jpg")
    spanish_logo = QLabel()
    spanish_logo.setPixmap(image)
    spanish_logo.setAlignment(QtCore.Qt.AlignCenter)
    spanish_logo.setStyleSheet("margin-top: 1px;")
    Widgets["spanish_logo"].append(spanish_logo)
    grid.addWidget(Widgets["spanish_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("End")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)
    next_button.clicked.connect(frame1)

    # Italian

def italian_question1():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    italian_q1 = QLabel("What is the correct translation for \"telephone\"?")
    italian_q1.setAlignment(QtCore.Qt.AlignCenter)
    italian_q1.setWordWrap(True)
    italian_q1.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    italian_q1.setFixedHeight(200)
    Labels["italian_ques"].append(italian_q1)

    iq1opt1 = create_buttons("La bicicletta")
    iq1opt2 = create_buttons("Telefono")
    iq1opt3 = create_buttons("L'ombrello")
    iq1opt4 = create_buttons("L'aquana")
    next_button = create_buttons("Next")

    Widgets["italianopt1"].append(iq1opt1)
    Widgets["italianopt2"].append(iq1opt2)
    Widgets["italianopt3"].append(iq1opt3)
    Widgets["italianopt4"].append(iq1opt4)
    grid.addWidget(Labels["italian_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["italianopt1"][-1], 2, 0)
    iq1opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt2"][-1], 2, 1)
    iq1opt2.clicked.connect(correct_ans)
    grid.addWidget(Widgets["italianopt3"][-1], 3, 0)
    iq1opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt4"][-1], 3, 1)
    iq1opt4.clicked.connect(wrong_ans)

    image = QPixmap("iq1.png")
    italian_logo = QLabel()
    italian_logo.setPixmap(image)
    italian_logo.setAlignment(QtCore.Qt.AlignCenter)
    italian_logo.setStyleSheet("margin-top: 1px;")
    Widgets["italian_logo"].append(italian_logo)
    grid.addWidget(Widgets["italian_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)
    next_button.clicked.connect(italian_question2)

def italian_question2():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    italian_q2 = QLabel("How many letters does the Italian Alphabet have?")
    italian_q2.setAlignment(QtCore.Qt.AlignCenter)
    italian_q2.setWordWrap(True)
    italian_q2.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    italian_q2.setFixedHeight(200)
    Labels["italian_ques"].append(italian_q2)

    iq2opt1 = create_buttons("33")
    iq2opt2 = create_buttons("69")
    iq2opt3 = create_buttons("21")
    iq2opt4 = create_buttons("100")
    next_button = create_buttons("Next")

    Widgets["italianopt1"].append(iq2opt1)
    Widgets["italianopt2"].append(iq2opt2)
    Widgets["italianopt3"].append(iq2opt3)
    Widgets["italianopt4"].append(iq2opt4)
    grid.addWidget(Labels["italian_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["italianopt1"][-1], 2, 0)
    iq2opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt2"][-1], 2, 1)
    iq2opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt3"][-1], 3, 0)
    iq2opt3.clicked.connect(correct_ans)
    grid.addWidget(Widgets["italianopt4"][-1], 3, 1)
    iq2opt4.clicked.connect(wrong_ans)

    image = QPixmap("iq2.jpg")
    italian_logo = QLabel()
    italian_logo.setPixmap(image)
    italian_logo.setAlignment(QtCore.Qt.AlignCenter)
    italian_logo.setStyleSheet("margin-top: 1px;")
    Widgets["italian_logo"].append(italian_logo)
    grid.addWidget(Widgets["italian_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(italian_question3)

def italian_question3():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    italian_q3 = QLabel("How many people world wide speak the Italian language? ")
    italian_q3.setAlignment(QtCore.Qt.AlignCenter)
    italian_q3.setWordWrap(True)
    italian_q3.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    italian_q3.setFixedHeight(200)
    Labels["italian_ques"].append(italian_q3)

    iq3opt1 = create_buttons("200 million")
    iq3opt2 = create_buttons("10 million")
    iq3opt3 = create_buttons("60 million")
    iq3opt4 = create_buttons("66 million")
    next_button = create_buttons("Next")

    Widgets["italianopt1"].append(iq3opt1)
    Widgets["italianopt2"].append(iq3opt2)
    Widgets["italianopt3"].append(iq3opt3)
    Widgets["italianopt4"].append(iq3opt4)
    grid.addWidget(Labels["italian_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["italianopt1"][-1], 2, 0)
    iq3opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt2"][-1], 2, 1)
    iq3opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt3"][-1], 3, 0)
    iq3opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt4"][-1], 3, 1)
    iq3opt4.clicked.connect(correct_ans)

    image = QPixmap("iq3.png")
    italian_logo = QLabel()
    italian_logo.setPixmap(image)
    italian_logo.setAlignment(QtCore.Qt.AlignCenter)
    italian_logo.setStyleSheet("margin-top: 1px;")
    Widgets["italian_logo"].append(italian_logo)
    grid.addWidget(Widgets["italian_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(italian_question4)

def italian_question4():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    italian_q4 = QLabel("To which language is the Italian language closest to?")
    italian_q4.setAlignment(QtCore.Qt.AlignCenter)
    italian_q4.setWordWrap(True)
    italian_q4.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    italian_q4.setFixedHeight(200)
    Labels["italian_ques"].append(italian_q4)

    iq4opt1 = create_buttons("Latin")
    iq4opt2 = create_buttons("English")
    iq4opt3 = create_buttons("German")
    iq4opt4 = create_buttons("French")
    next_button = create_buttons("Next")

    Widgets["italianopt1"].append(iq4opt1)
    Widgets["italianopt2"].append(iq4opt2)
    Widgets["italianopt3"].append(iq4opt3)
    Widgets["italianopt4"].append(iq4opt4)
    grid.addWidget(Labels["italian_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["italianopt1"][-1], 2, 0)
    iq4opt1.clicked.connect(correct_ans)
    grid.addWidget(Widgets["italianopt2"][-1], 2, 1)
    iq4opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt3"][-1], 3, 0)
    iq4opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt4"][-1], 3, 1)
    iq4opt4.clicked.connect(wrong_ans)

    image = QPixmap("iq4.jpg")
    italian_logo = QLabel()
    italian_logo.setPixmap(image)
    italian_logo.setAlignment(QtCore.Qt.AlignCenter)
    italian_logo.setStyleSheet("margin-top: 1px;")
    Widgets["italian_logo"].append(italian_logo)
    grid.addWidget(Widgets["italian_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(italian_question5)

def italian_question5():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    italian_q5 = QLabel("The Italian Language is also known as the language of ")
    italian_q5.setAlignment(QtCore.Qt.AlignCenter)
    italian_q5.setWordWrap(True)
    italian_q5.setStyleSheet("*{border: 4px solid '#68B31A';" +
                             "color: 'black';" +
                             "font-size: 30px;" +
                             "border-radius: 15px;" +
                             "padding: 15px 0;" +
                             "margin: 20px;}" +
                             "*:hover{background: '#68B31A';}"
                             )
    italian_q5.setFixedHeight(200)
    Labels["italian_ques"].append(italian_q5)

    iq5opt1 = create_buttons("Music")
    iq5opt2 = create_buttons("Maths")
    iq5opt3 = create_buttons("Biology")
    iq5opt4 = create_buttons("Love")
    next_button = create_buttons("Next")

    Widgets["italianopt1"].append(iq5opt1)
    Widgets["italianopt2"].append(iq5opt2)
    Widgets["italianopt3"].append(iq5opt3)
    Widgets["italianopt4"].append(iq5opt4)
    grid.addWidget(Labels["italian_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["italianopt1"][-1], 2, 0)
    iq5opt1.clicked.connect(correct_ans)
    grid.addWidget(Widgets["italianopt2"][-1], 2, 1)
    iq5opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt3"][-1], 3, 0)
    iq5opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["italianopt4"][-1], 3, 1)
    iq5opt4.clicked.connect(correct_ans)

    image = QPixmap("iq5.png")
    italian_logo = QLabel()
    italian_logo.setPixmap(image)
    italian_logo.setAlignment(QtCore.Qt.AlignCenter)
    italian_logo.setStyleSheet("margin-top: 1px;")
    Widgets["italian_logo"].append(italian_logo)
    grid.addWidget(Widgets["italian_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("End")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)
    next_button.clicked.connect(frame1)

    # French

def french_question1():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    french_q1 = QLabel("What is the name of the French National Anthem?")
    french_q1.setAlignment(QtCore.Qt.AlignCenter)
    french_q1.setWordWrap(True)
    french_q1.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    french_q1.setFixedHeight(200)
    Labels["french_ques"].append(french_q1)

    fq1opt1 = create_buttons("La Parisienne")
    fq1opt2 = create_buttons("La France")
    fq1opt3 = create_buttons("La Nicoise")
    fq1opt4 = create_buttons("La Marseillaise")
    next_button = create_buttons("Next")

    Widgets["frenchopt1"].append(fq1opt1)
    Widgets["frenchopt2"].append(fq1opt2)
    Widgets["frenchopt3"].append(fq1opt3)
    Widgets["frenchopt4"].append(fq1opt4)
    grid.addWidget(Labels["french_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["frenchopt1"][-1], 2, 0)
    fq1opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt2"][-1], 2, 1)
    fq1opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt3"][-1], 3, 0)
    fq1opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt4"][-1], 3, 1)
    fq1opt4.clicked.connect(correct_ans)

    image = QPixmap("fq1.jpg")
    french_logo = QLabel()
    french_logo.setPixmap(image)
    french_logo.setAlignment(QtCore.Qt.AlignCenter)
    french_logo.setStyleSheet("margin-top: 1px;")
    Widgets["french_logo"].append(french_logo)
    grid.addWidget(Widgets["french_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(french_question2)

def french_question2():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    french_q2 = QLabel("Which of these is a tourist attraction in France?")
    french_q2.setAlignment(QtCore.Qt.AlignCenter)
    french_q2.setWordWrap(True)
    french_q2.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    french_q2.setFixedHeight(200)
    Labels["french_ques"].append(french_q2)

    fq2opt1 = create_buttons("Disneyland")
    fq2opt2 = create_buttons("Eiffel Tower")
    fq2opt3 = create_buttons("Versailles Palace")
    fq2opt4 = create_buttons("All of the above")
    next_button = create_buttons("Next")

    Widgets["frenchopt1"].append(fq2opt1)
    Widgets["frenchopt2"].append(fq2opt2)
    Widgets["frenchopt3"].append(fq2opt3)
    Widgets["frenchopt4"].append(fq2opt4)
    grid.addWidget(Labels["french_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["frenchopt1"][-1], 2, 0)
    fq2opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt2"][-1], 2, 1)
    fq2opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt3"][-1], 3, 0)
    fq2opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt4"][-1], 3, 1)
    fq2opt4.clicked.connect(correct_ans)

    image = QPixmap("fq2.jpg")
    french_logo = QLabel()
    french_logo.setPixmap(image)
    french_logo.setAlignment(QtCore.Qt.AlignCenter)
    french_logo.setStyleSheet("margin-top: 1px;")
    Widgets["french_logo"].append(french_logo)
    grid.addWidget(Widgets["french_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(french_question3)

def french_question3():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    french_q3 = QLabel("What is good-bye in french? ")
    french_q3.setAlignment(QtCore.Qt.AlignCenter)
    french_q3.setWordWrap(True)
    french_q3.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    french_q3.setFixedHeight(200)
    Labels["french_ques"].append(french_q3)

    fq3opt1 = create_buttons("Bonsoir")
    fq3opt2 = create_buttons("Au revoir")
    fq3opt3 = create_buttons("Gauche")
    fq3opt4 = create_buttons("Merci")
    next_button = create_buttons("Next")

    Widgets["frenchopt1"].append(fq3opt1)
    Widgets["frenchopt2"].append(fq3opt2)
    Widgets["frenchopt3"].append(fq3opt3)
    Widgets["frenchopt4"].append(fq3opt4)
    grid.addWidget(Labels["french_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["frenchopt1"][-1], 2, 0)
    fq3opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt2"][-1], 2, 1)
    fq3opt2.clicked.connect(correct_ans)
    grid.addWidget(Widgets["frenchopt3"][-1], 3, 0)
    fq3opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt4"][-1], 3, 1)
    fq3opt4.clicked.connect(wrong_ans)

    image = QPixmap("fq3.png")
    french_logo = QLabel()
    french_logo.setPixmap(image)
    french_logo.setAlignment(QtCore.Qt.AlignCenter)
    french_logo.setStyleSheet("margin-top: 1px;")
    Widgets["french_logo"].append(french_logo)
    grid.addWidget(Widgets["french_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(french_question4)

def french_question4():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    french_q4 = QLabel("France is home to the world’s largest museum. Which one is it?")
    french_q4.setAlignment(QtCore.Qt.AlignCenter)
    french_q4.setWordWrap(True)
    french_q4.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    french_q4.setFixedHeight(200)
    Labels["french_ques"].append(french_q4)

    fq4opt1 = create_buttons("The Louvre")
    fq4opt2 = create_buttons("Vatican Mueseum")
    fq4opt3 = create_buttons("National Gallery")
    fq4opt4 = create_buttons("Centre Pompidou")
    next_button = create_buttons("Next")

    Widgets["frenchopt1"].append(fq4opt1)
    Widgets["frenchopt2"].append(fq4opt2)
    Widgets["frenchopt3"].append(fq4opt3)
    Widgets["frenchopt4"].append(fq4opt4)
    grid.addWidget(Labels["french_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["frenchopt1"][-1], 2, 0)
    fq4opt1.clicked.connect(correct_ans)
    grid.addWidget(Widgets["frenchopt2"][-1], 2, 1)
    fq4opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt3"][-1], 3, 0)
    fq4opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt4"][-1], 3, 1)
    fq4opt4.clicked.connect(wrong_ans)

    image = QPixmap("fq4.jpg")
    french_logo = QLabel()
    french_logo.setPixmap(image)
    french_logo.setAlignment(QtCore.Qt.AlignCenter)
    french_logo.setStyleSheet("margin-top: 1px;")
    Widgets["french_logo"].append(french_logo)
    grid.addWidget(Widgets["french_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(french_question5)

def french_question5():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    french_q5 = QLabel("When is Bastille Day (Independence Day) of France? ")
    french_q5.setAlignment(QtCore.Qt.AlignCenter)
    french_q5.setWordWrap(True)
    french_q5.setStyleSheet("*{border: 4px solid '#68B31A';" +
                            "color: 'black';" +
                            "font-size: 30px;" +
                            "border-radius: 15px;" +
                            "padding: 15px 0;" +
                            "margin: 20px;}" +
                            "*:hover{background: '#68B31A';}"
                            )
    french_q5.setFixedHeight(200)
    Labels["french_ques"].append(french_q5)

    fq5opt1 = create_buttons("28 July")
    fq5opt2 = create_buttons("1 August")
    fq5opt3 = create_buttons("14 July")
    fq5opt4 = create_buttons("5 March")
    next_button = create_buttons("Next")

    Widgets["frenchopt1"].append(fq5opt1)
    Widgets["frenchopt2"].append(fq5opt2)
    Widgets["frenchopt3"].append(fq5opt3)
    Widgets["frenchopt4"].append(fq5opt4)
    grid.addWidget(Labels["french_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["frenchopt1"][-1], 2, 0)
    fq5opt1.clicked.connect(correct_ans)
    grid.addWidget(Widgets["frenchopt2"][-1], 2, 1)
    fq5opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["frenchopt3"][-1], 3, 0)
    fq5opt3.clicked.connect(correct_ans)
    grid.addWidget(Widgets["frenchopt4"][-1], 3, 1)
    fq5opt4.clicked.connect(wrong_ans)

    image = QPixmap("fq5.jpg")
    french_logo = QLabel()
    french_logo.setPixmap(image)
    french_logo.setAlignment(QtCore.Qt.AlignCenter)
    french_logo.setStyleSheet("margin-top: 1px;")
    Widgets["french_logo"].append(french_logo)
    grid.addWidget(Widgets["french_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("End")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)
    next_button.clicked.connect(frame1)

    # Spanish

def portuguese_question1():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    portuguese_q1 = QLabel("Which of the following countries is known as the \"Land of Explorers\"")
    portuguese_q1.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_q1.setWordWrap(True)
    portuguese_q1.setStyleSheet("*{border: 4px solid '#68B31A';" +
                                "color: 'black';" +
                                "font-size: 30px;" +
                                "border-radius: 15px;" +
                                "padding: 15px 0;" +
                                "margin: 20px;}" +
                                "*:hover{background: '#68B31A';}"
                                )
    portuguese_q1.setFixedHeight(200)
    Labels["portuguese_ques"].append(portuguese_q1)

    portuguese_1_opt1 = create_buttons("Portugal")  # Correct answer
    portuguese_1_opt2 = create_buttons("Morocco")
    portuguese_1_opt3 = create_buttons("Angola")
    portuguese_1_opt4 = create_buttons("Algeria")
    next_button = create_buttons("Next")

    Widgets["portuguese_answer1"].append(portuguese_1_opt1)
    Widgets["portuguese_answer2"].append(portuguese_1_opt2)
    Widgets["portuguese_answer3"].append(portuguese_1_opt3)
    Widgets["portuguese_answer4"].append(portuguese_1_opt4)
    grid.addWidget(Labels["portuguese_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["portuguese_answer1"][-1], 2, 0)
    portuguese_1_opt1.clicked.connect(correct_ans)
    grid.addWidget(Widgets["portuguese_answer2"][-1], 2, 1)
    portuguese_1_opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer3"][-1], 3, 0)
    portuguese_1_opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer4"][-1], 3, 1)
    portuguese_1_opt4.clicked.connect(wrong_ans)

    image = QPixmap("pq1.jpg")
    portuguese_logo = QLabel()
    portuguese_logo.setPixmap(image)
    portuguese_logo.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_logo.setStyleSheet("margin-top: 1px;")
    Widgets["portuguese_logo"].append(portuguese_logo)
    grid.addWidget(Widgets["portuguese_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(portuguese_question2)

def portuguese_question2():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    portuguese_q2 = QLabel("What is the capital city of Portugal?")
    portuguese_q2.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_q2.setWordWrap(True)
    portuguese_q2.setStyleSheet("*{border: 4px solid '#68B31A';" +
                                "color: 'black';" +
                                "font-size: 30px;" +
                                "border-radius: 15px;" +
                                "padding: 15px 0;" +
                                "margin: 20px;}" +
                                "*:hover{background: '#68B31A';}"
                                )
    portuguese_q2.setFixedHeight(200)
    Labels["portuguese_ques"].append(portuguese_q2)

    portuguese_2_opt1 = create_buttons("Evora")
    portuguese_2_opt2 = create_buttons("Guarda")
    portuguese_2_opt3 = create_buttons("Lisbon")  # correct answer
    portuguese_2_opt4 = create_buttons("Porto")
    next_button = create_buttons("Next")

    Widgets["portuguese_answer1"].append(portuguese_2_opt1)
    Widgets["portuguese_answer2"].append(portuguese_2_opt2)
    Widgets["portuguese_answer3"].append(portuguese_2_opt3)
    Widgets["portuguese_answer4"].append(portuguese_2_opt4)
    grid.addWidget(Labels["portuguese_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["portuguese_answer1"][-1], 2, 0)
    portuguese_2_opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer2"][-1], 2, 1)
    portuguese_2_opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer3"][-1], 3, 0)
    portuguese_2_opt3.clicked.connect(correct_ans)
    grid.addWidget(Widgets["portuguese_answer4"][-1], 3, 1)
    portuguese_2_opt4.clicked.connect(wrong_ans)

    image = QPixmap("pq2.jpg")
    portuguese_logo = QLabel()
    portuguese_logo.setPixmap(image)
    portuguese_logo.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_logo.setStyleSheet("margin-top: 1px;")
    Widgets["portuguese_logo"].append(portuguese_logo)
    grid.addWidget(Widgets["portuguese_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(portuguese_question3)

def portuguese_question3():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    portuguese_q3 = QLabel("Who is the famous football player born in Portugal?")
    portuguese_q3.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_q3.setWordWrap(True)
    portuguese_q3.setStyleSheet("*{border: 4px solid '#68B31A';" +
                                "color: 'black';" +
                                "font-size: 30px;" +
                                "border-radius: 15px;" +
                                "padding: 15px 0;" +
                                "margin: 20px;}" +
                                "*:hover{background: '#68B31A';}"
                                )
    portuguese_q3.setFixedHeight(200)
    Labels["portuguese_ques"].append(portuguese_q3)

    portuguese_3_opt1 = create_buttons("Lionel Messi")
    portuguese_3_opt2 = create_buttons("Christiano Ronaldo")  # correct answer
    portuguese_3_opt3 = create_buttons("Sadio Mane")
    portuguese_3_opt4 = create_buttons("Kevin De Bruyne")
    next_button = create_buttons("Next")

    Widgets["portuguese_answer1"].append(portuguese_3_opt1)
    Widgets["portuguese_answer2"].append(portuguese_3_opt2)
    Widgets["portuguese_answer3"].append(portuguese_3_opt3)
    Widgets["portuguese_answer4"].append(portuguese_3_opt4)
    grid.addWidget(Labels["portuguese_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["portuguese_answer1"][-1], 2, 0)
    portuguese_3_opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer2"][-1], 2, 1)
    portuguese_3_opt2.clicked.connect(correct_ans)
    grid.addWidget(Widgets["portuguese_answer3"][-1], 3, 0)
    portuguese_3_opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer4"][-1], 3, 1)
    portuguese_3_opt4.clicked.connect(wrong_ans)

    image = QPixmap("pq3.jpg")
    portuguese_logo = QLabel()
    portuguese_logo.setPixmap(image)
    portuguese_logo.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_logo.setStyleSheet("margin-top: 1px;")
    Widgets["portuguese_logo"].append(portuguese_logo)
    grid.addWidget(Widgets["portuguese_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(portuguese_question4)

def portuguese_question4():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    portuguese_q4 = QLabel("What does \"Obrigado\" mean in Portuguese?")
    portuguese_q4.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_q4.setWordWrap(True)
    portuguese_q4.setStyleSheet("*{border: 4px solid '#68B31A';" +
                                "color: 'black';" +
                                "font-size: 30px;" +
                                "border-radius: 15px;" +
                                "padding: 15px 0;" +
                                "margin: 20px;}" +
                                "*:hover{background: '#68B31A';}"
                                )
    portuguese_q4.setFixedHeight(200)
    Labels["portuguese_ques"].append(portuguese_q4)

    portuguese_4_opt1 = create_buttons("Excuse me")
    portuguese_4_opt2 = create_buttons("Sorry")
    portuguese_4_opt3 = create_buttons("Hello")
    portuguese_4_opt4 = create_buttons("Thank you")  # correct answer
    next_button = create_buttons("Next")

    Widgets["portuguese_answer1"].append(portuguese_4_opt1)
    Widgets["portuguese_answer2"].append(portuguese_4_opt2)
    Widgets["portuguese_answer3"].append(portuguese_4_opt3)
    Widgets["portuguese_answer4"].append(portuguese_4_opt4)
    grid.addWidget(Labels["portuguese_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["portuguese_answer1"][-1], 2, 0)
    portuguese_4_opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer2"][-1], 2, 1)
    portuguese_4_opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer3"][-1], 3, 0)
    portuguese_4_opt3.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer4"][-1], 3, 1)
    portuguese_4_opt4.clicked.connect(correct_ans)

    image = QPixmap("pq4.png")
    portuguese_logo = QLabel()
    portuguese_logo.setPixmap(image)
    portuguese_logo.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_logo.setStyleSheet("margin-top: 1px;")
    Widgets["portuguese_logo"].append(portuguese_logo)
    grid.addWidget(Widgets["portuguese_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("Next")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)

    next_button.clicked.connect(portuguese_question5)

def portuguese_question5():
    for i in range(0, len(Labels["correct_ans"])):
        Labels["correct_ans"][i].hide()
    for i in range(0, len(Labels["wrong_ans"])):
        Labels["wrong_ans"][i].hide()
    clear_widgets()
    portuguese_q5 = QLabel("Portuguese is the official language of which of the following countries?")
    portuguese_q5.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_q5.setWordWrap(True)
    portuguese_q5.setStyleSheet("*{border: 4px solid '#68B31A';" +
                                "color: 'black';" +
                                "font-size: 30px;" +
                                "border-radius: 15px;" +
                                "padding: 15px 0;" +
                                "margin: 20px;}" +
                                "*:hover{background: '#68B31A';}"
                                )
    portuguese_q5.setFixedHeight(200)
    Labels["portuguese_ques"].append(portuguese_q5)

    portuguese_5_opt1 = create_buttons("Ecuador")
    portuguese_5_opt2 = create_buttons("Mexico")
    portuguese_5_opt3 = create_buttons("Angola")  # correct answer
    portuguese_5_opt4 = create_buttons("Congo")
    next_button = create_buttons("Next")

    Widgets["portuguese_answer1"].append(portuguese_5_opt1)
    Widgets["portuguese_answer2"].append(portuguese_5_opt2)
    Widgets["portuguese_answer3"].append(portuguese_5_opt3)
    Widgets["portuguese_answer4"].append(portuguese_5_opt4)
    grid.addWidget(Labels["portuguese_ques"][-1], 1, 0, 1, 2)
    grid.addWidget(Widgets["portuguese_answer1"][-1], 2, 0)
    portuguese_5_opt1.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer2"][-1], 2, 1)
    portuguese_5_opt2.clicked.connect(wrong_ans)
    grid.addWidget(Widgets["portuguese_answer3"][-1], 3, 0)
    portuguese_5_opt3.clicked.connect(correct_ans)
    grid.addWidget(Widgets["portuguese_answer4"][-1], 3, 1)
    portuguese_5_opt4.clicked.connect(wrong_ans)

    image = QPixmap("pq5.jpg")
    portuguese_logo = QLabel()
    portuguese_logo.setPixmap(image)
    portuguese_logo.setAlignment(QtCore.Qt.AlignCenter)
    portuguese_logo.setStyleSheet("margin-top: 1px;")
    Widgets["portuguese_logo"].append(portuguese_logo)
    grid.addWidget(Widgets["portuguese_logo"][-1], 1, 2, 1, 1)

    next_button = create_buttons("End")
    Widgets["nextq"].append(next_button)
    grid.addWidget(Widgets["nextq"][-1], 4, 1)
    next_button.clicked.connect(frame1)

# Custom Text Frame
def uni_trans():
    clear_widgets()
    
    image = QPixmap("custom.png")
    other_logo = QLabel()
    other_logo.setPixmap(image)
    other_logo.setAlignment(QtCore.Qt.AlignCenter)
    other_logo.setStyleSheet("margin-top: 1px;")
    Widgets["other_logo"].append(other_logo)
    grid.addWidget(Widgets["other_logo"][-1], 0, 0,1,2)

    nameLabel = QLabel()  
    nameLabel.setText('Text to be Translated :')
    nameLabel.setAlignment(QtCore.Qt.AlignRight)
    nameLabel.setStyleSheet("*{border: 4px solid '#BCEE68';"
                            + "border-radius: 15px;" +
                            "font-size: 25px;" +
                            "color: 'black';" +
                            "padding: 15px 0;" +
                            "margin: 25px 150px;}")
    
    Labels["other_labels"].append(nameLabel)
    grid.addWidget(Labels["other_labels"][-1],1, 0, 1, 1)
    #nameLabel.move(20, 20)

    line = QLineEdit()
    Widgets["textbox"].append(line)
    grid.addWidget(Widgets["textbox"][-1], 1, 1, 1, 1)
    line.move(80, 20)
    line.resize(1000, 1000)

    line.setStyleSheet("*{border: 4px solid '#C84A6B';"
                       + "border-radius: 15px;" +
                       "font-size: 25px;" +
                       "color: 'black';" +
                       "padding: 15px 0;" +
                       "margin: 25px 150px;}")

    pybutton = QPushButton('Translate')
    pybutton.setStyleSheet("*{border: 4px solid '#C84A6B';"
                           + "border-radius: 15px;" +
                           "font-size: 25px;" +
                           "color: 'black';" +
                           "padding: 15px 0;" +
                           "margin: 25px 150px;}" +
                           "*:hover{background:'#C84A6B';}")
    
    pybutton.resize(200, 32)
    pybutton.move(80, 60)
    Widgets["trans_btn"].append(pybutton)
    grid.addWidget(Widgets["trans_btn"][-1], 2, 1, 1, 1)
    pybutton.clicked.connect(clickMethod)

    combo = QComboBox()
    langlist = ["", "German", "Italian", "Spanish", "Portuguese", "French"]
    combo.addItems(langlist)
    combo.setStyleSheet("*{border: 4px solid '#C84A6B';"
                        + "border-radius: 15px;" +
                        "font-size: 25px;" +
                        "color: 'black';" +
                        "padding: 15px 0;" +
                        "margin: 25px 150px;}" +
                        "*:hover{background:'#C84A6B';}")
    Widgets["comboBox"].append(combo)
    grid.addWidget(Widgets["comboBox"][-1], 2, 0, 1, 1)
    

    invi_label1 = QLabel()
    invi_label1.setAlignment(QtCore.Qt.AlignCenter)
    invi_label1.setFixedWidth(800)
    invi_label1.setStyleSheet("*{border: 4px solid '#5D478B';" +
                              "background-color: '#BDA0CB;' "
                              + "border-radius: 15px;" +
                              "color: '#BDA0CB';" +
                              "padding: 15px 0;" +
                              "margin: 25px 150px;}")
    Labels["invilab"].append(invi_label1)
    grid.addWidget(Labels["invilab"][-1], 6, 0, 1, 1)

    

    invi_label2 = QLabel()
    invi_label2.setAlignment(QtCore.Qt.AlignCenter)
    invi_label2.setFixedWidth(800)
    invi_label2.setStyleSheet("*{border: 4px solid '#5D478B';" +
                              "background-color: '#BDA0CB;' "
                              + "border-radius: 15px;" +
                              "color: '#BDA0CB';" +
                              "padding: 15px 0;" +
                              "margin: 25px 150px;}")
    Labels["invilab"].append(invi_label2)
    grid.addWidget(Labels["invilab"][-1], 7, 0, 1, 1)

    

    exit_btn = create_buttons("Exit")
    Widgets["other_buttons"].append(exit_btn)
    grid.addWidget(Widgets["other_buttons"][-1], 5, 1, 1, 1)
    exit_btn.clicked.connect(frame2)

def quiz_start():
    clear_widgets()
    g_button = create_buttons("German")
    s_button = create_buttons("Spanish")
    i_button = create_buttons("Italian")
    f_button = create_buttons("French")
    p_button = create_buttons("Portuguese")

    Widgets["German"].append(g_button)
    g_button.clicked.connect(german_question1)
    Widgets["Spanish"].append(s_button)
    s_button.clicked.connect(spanish_question1)
    Widgets["Italian"].append(i_button)
    i_button.clicked.connect(italian_question1)
    Widgets["French"].append(f_button)
    f_button.clicked.connect(french_question1)
    Widgets["Portuguese"].append(p_button)
    p_button.clicked.connect(portuguese_question1)

    grid.addWidget(Widgets["German"][-1], 1, 0, 1, 1)
    grid.addWidget(Widgets["Spanish"][-1], 2, 0, 1, 1)
    grid.addWidget(Widgets["Italian"][-1], 3, 0, 1, 1)
    grid.addWidget(Widgets["French"][-1], 4, 0, 1, 1)
    grid.addWidget(Widgets["Portuguese"][-1], 5, 0, 1, 1)

# Starting program
welcome_frame()
Window.show()
sys.exit(app.exec_())