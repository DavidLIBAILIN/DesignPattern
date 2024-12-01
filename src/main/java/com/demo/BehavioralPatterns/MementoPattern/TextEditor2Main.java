package com.demo.BehavioralPatterns.MementoPattern;

public class TextEditor2Main {
    public static void main(String[] args) {
        TextEditor2 textEditor = new TextEditor2();

        textEditor.write("This is the first sentence");

        TextEditor2.Memento saved = textEditor.save();

        textEditor.write(" This is the second sentence.");
        System.out.println("Before restore: " + textEditor.save().getContent()); // 打印出当前文本

        // 恢复到之前的状态
        textEditor.restore(saved);
        System.out.println("After restore: " + textEditor.save().getContent()); // 打印出当前文本

    }
}

class TextEditor2 {

    private StringBuilder content;

    public TextEditor2() {
        this.content = new StringBuilder();
    }

    public void write(String text) {
        content.append(text);
        System.out.println("Current content: " + content.toString());
    }

    public Memento save() {
        return new Memento(content.toString());
    }

    public void restore(Memento memento) {
        content = new StringBuilder(memento.getContent());
    }

    static class Memento {

        private String content;

        public Memento(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }
}
