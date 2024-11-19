package com.example.ejercicio432;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.text.TextAlignment;
import javafx.util.Callback;

import java.text.Format;

public class FormattedTableCellFactory<S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {
    private TextAlignment alignment;
    private Format format;

    public TextAlignment getAlignment() {
        return alignment;
    }

    public void setAlignment(TextAlignment alignment) {
        this.alignment = alignment;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public TableCell<S, T> call(TableColumn<S, T> param) {
        return new TableCell<>() {
            @Override
            protected void updateItem(T item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    if (format != null) {
                        setText(format.format(item));
                    } else if (item instanceof Node) {
                        setGraphic((Node) item);
                    } else {
                        setText(item.toString());
                    }
                }

                switch (alignment) {
                    case CENTER -> setAlignment(Pos.CENTER);
                    case RIGHT -> setAlignment(Pos.CENTER_RIGHT);
                    default -> setAlignment(Pos.CENTER_LEFT);
                }
            }
        };
    }
}
