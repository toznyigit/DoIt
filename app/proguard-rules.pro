# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

1. APPLICABILITY AND DEFINITIONS
 
-This License applies to any manual or other work that contains a
-notice placed by the copyright holder saying it can be distributed
-under the terms of this License.  The "Document", below, refers to any
-such manual or work.  Any member of the public is a licensee, and is
-addressed as "you".
+This License applies to any manual or other work, in any medium, that
+contains a notice placed by the copyright holder saying it can be
+distributed under the terms of this License.  Such a notice grants a
+world-wide, royalty-free license, unlimited in duration, to use that
+work under the conditions stated herein.  The "Document", below,
+refers to any such manual or work.  Any member of the public is a
+licensee, and is addressed as "you".  You accept the license if you
+copy, modify or distribute the work in a way requiring permission
+under copyright law.
 
 A "Modified Version" of the Document means any work containing the
 Document or a portion of it, either copied verbatim, or with
@@ -47,7 +52,7 @@
 the Document that deals exclusively with the relationship of the
 publishers or authors of the Document to the Document's overall subject
 (or to related matters) and contains nothing that could fall directly
-within that overall subject.  (For example, if the Document is in part a
+within that overall subject.  (Thus, if the Document is in part a
 textbook of mathematics, a Secondary Section may not explain any
 mathematics.)  The relationship could be a matter of historical
 connection with the subject or with related matters, or of legal,
@@ -56,33 +61,40 @@
 
 The "Invariant Sections" are certain Secondary Sections whose titles
 are designated, as being those of Invariant Sections, in the notice
-that says that the Document is released under this License.
+that says that the Document is released under this License.  If a
+section does not fit the above definition of Secondary then it is not
+allowed to be designated as Invariant.  The Document may contain zero
+Invariant Sections.  If the Document does not identify any Invariant
+Sections then there are none.
 
 The "Cover Texts" are certain short passages of text that are listed,
 as Front-Cover Texts or Back-Cover Texts, in the notice that says that
-the Document is released under this License.
+the Document is released under this License.  A Front-Cover Text may
+be at most 5 words, and a Back-Cover Text may be at most 25 words.
 
 A "Transparent" copy of the Document means a machine-readable copy,
 represented in a format whose specification is available to the
-general public, whose contents can be viewed and edited directly and
+general public, that is suitable for revising the document
 straightforwardly with generic text editors or (for images composed of
 pixels) generic paint programs or (for drawings) some widely available
 drawing editor, and that is suitable for input to text formatters or
 for automatic translation to a variety of formats suitable for input
 to text formatters.  A copy made in an otherwise Transparent file
-format whose markup has been designed to thwart or discourage
-subsequent modification by readers is not Transparent.  A copy that is
-not "Transparent" is called "Opaque".
+format whose markup, or absence of markup, has been arranged to thwart
+or discourage subsequent modification by readers is not Transparent.
+An image format is not Transparent if used for any substantial amount
+of text.  A copy that is not "Transparent" is called "Opaque".
 
 Examples of suitable formats for Transparent copies include plain
 ASCII without markup, Texinfo input format, LaTeX input format, SGML
 or XML using a publicly available DTD, and standard-conforming simple
-HTML designed for human modification.  Opaque formats include
-PostScript, PDF, proprietary formats that can be read and edited only
-by proprietary word processors, SGML or XML for which the DTD and/or
+HTML, PostScript or PDF designed for human modification.  Examples of
+transparent image formats include PNG, XCF and JPG.  Opaque formats
+include proprietary formats that can be read and edited only by
+proprietary word processors, SGML or XML for which the DTD and/or
 processing tools are not generally available, and the
-machine-generated HTML produced by some word processors for output
-purposes only.
+machine-generated HTML, PostScript or PDF produced by some word
+processors for output purposes only.
 
 The "Title Page" means, for a printed book, the title page itself,
 plus such following pages as are needed to hold, legibly, the material
@@ -91,6 +103,21 @@
 the text near the most prominent appearance of the work's title,
 preceding the beginning of the body of the text.
 
+A section "Entitled XYZ" means a named subunit of the Document whose
+title either is precisely XYZ or contains XYZ in parentheses following
+text that translates XYZ in another language.  (Here XYZ stands for a
+specific section name mentioned below, such as "Acknowledgements",
+"Dedications", "Endorsements", or "History".)  To "Preserve the Title"
+of such a section when you modify the Document means that it remains a
+section "Entitled XYZ" according to this definition.
+
+The Document may include Warranty Disclaimers next to the notice which
+states that this License applies to the Document.  These Warranty
+Disclaimers are considered to be included by reference in this
+License, but only as regards disclaiming warranties: any other
+implication that these Warranty Disclaimers may have is void and has
+no effect on the meaning of this License.
+
 
 2. VERBATIM COPYING
 
@@ -110,9 +137,10 @@
 
 3. COPYING IN QUANTITY
 
-If you publish printed copies of the Document numbering more than 100,
-and the Document's license notice requires Cover Texts, you must enclose
-the copies in covers that carry, clearly and legibly, all these Cover
+If you publish printed copies (or copies in media that commonly have
+printed covers) of the Document, numbering more than 100, and the
+Document's license notice requires Cover Texts, you must enclose the
+copies in covers that carry, clearly and legibly, all these Cover
 Texts: Front-Cover Texts on the front cover, and Back-Cover Texts on
 the back cover.  Both covers must also clearly and legibly identify
 you as the publisher of these copies.  The front cover must present
@@ -130,16 +158,15 @@
 If you publish or distribute Opaque copies of the Document numbering
 more than 100, you must either include a machine-readable Transparent
 copy along with each Opaque copy, or state in or with each Opaque copy
-a publicly-accessible computer-network location containing a complete
-Transparent copy of the Document, free of added material, which the
-general network-using public has access to download anonymously at no
-charge using public-standard network protocols.  If you use the latter
-option, you must take reasonably prudent steps, when you begin
-distribution of Opaque copies in quantity, to ensure that this
-Transparent copy will remain thus accessible at the stated location
-until at least one year after the last time you distribute an Opaque
-copy (directly or through your agents or retailers) of that edition to
-the public.
+a computer-network location from which the general network-using
+public has access to download using public-standard network protocols
+a complete Transparent copy of the Document, free of added material.
+If you use the latter option, you must take reasonably prudent steps,
+when you begin distribution of Opaque copies in quantity, to ensure
+that this Transparent copy will remain thus accessible at the stated
+location until at least one year after the last time you distribute an
+Opaque copy (directly or through your agents or retailers) of that
+edition to the public.
 
 It is requested, but not required, that you contact the authors of the
 Document well before redistributing any large number of copies, to give
@@ -163,7 +190,8 @@
 B. List on the Title Page, as authors, one or more persons or entities
    responsible for authorship of the modifications in the Modified
    Version, together with at least five of the principal authors of the
-   Document (all of its principal authors, if it has less than five).
+   Document (all of its principal authors, if it has fewer than five),
+   unless they release you from this requirement.
 C. State on the Title page the name of the publisher of the
    Modified Version, as the publisher.
 D. Preserve all the copyright notices of the Document.
@@ -175,10 +203,10 @@
 G. Preserve in that license notice the full lists of Invariant Sections
    and required Cover Texts given in the Document's license notice.
 H. Include an unaltered copy of this License.
-I. Preserve the section entitled "History", and its title, and add to
-   it an item stating at least the title, year, new authors, and
+I. Preserve the section Entitled "History", Preserve its Title, and add
+   to it an item stating at least the title, year, new authors, and
    publisher of the Modified Version as given on the Title Page.  If
-   there is no section entitled "History" in the Document, create one
+   there is no section Entitled "History" in the Document, create one
    stating the title, year, authors, and publisher of the Document as
    given on its Title Page, then add an item describing the Modified
    Version as stated in the previous sentence.
@@ -189,17 +217,18 @@
    You may omit a network location for a work that was published at
    least four years before the Document itself, or if the original
    publisher of the version it refers to gives permission.
-K. In any section entitled "Acknowledgements" or "Dedications",
-   preserve the section's title, and preserve in the section all the
-   substance and tone of each of the contributor acknowledgements
+K. For any section Entitled "Acknowledgements" or "Dedications",
+   Preserve the Title of the section, and preserve in the section all
+   the substance and tone of each of the contributor acknowledgements
    and/or dedications given therein.
 L. Preserve all the Invariant Sections of the Document,
    unaltered in their text and in their titles.  Section numbers
    or the equivalent are not considered part of the section titles.
-M. Delete any section entitled "Endorsements".  Such a section
+M. Delete any section Entitled "Endorsements".  Such a section
    may not be included in the Modified Version.
-N. Do not retitle any existing section as "Endorsements"
+N. Do not retitle any existing section to be Entitled "Endorsements"
    or to conflict in title with any Invariant Section.
+O. Preserve any Warranty Disclaimers.
 
 If the Modified Version includes new front-matter sections or
 appendices that qualify as Secondary Sections and contain no material
@@ -208,7 +237,7 @@
 list of Invariant Sections in the Modified Version's license notice.
 These titles must be distinct from any other section titles.
 
-You may add a section entitled "Endorsements", provided it contains
+You may add a section Entitled "Endorsements", provided it contains
 nothing but endorsements of your Modified Version by various
 parties--for example, statements of peer review or that the text has
 been approved by an organization as the authoritative definition of a
@@ -236,7 +265,7 @@
 versions, provided that you include in the combination all of the
 Invariant Sections of all of the original documents, unmodified, and
 list them all as Invariant Sections of your combined work in its
-license notice.
+license notice, and that you preserve all their Warranty Disclaimers.
 
 The combined work need only contain one copy of this License, and
 multiple identical Invariant Sections may be replaced with a single
@@ -247,11 +276,11 @@
 Make the same adjustment to the section titles in the list of
 Invariant Sections in the license notice of the combined work.
 
-In the combination, you must combine any sections entitled "History"
-in the various original documents, forming one section entitled
-"History"; likewise combine any sections entitled "Acknowledgements",
-and any sections entitled "Dedications".  You must delete all sections
-entitled "Endorsements."
+In the combination, you must combine any sections Entitled "History"
+in the various original documents, forming one section Entitled
+"History"; likewise combine any sections Entitled "Acknowledgements",
+and any sections Entitled "Dedications".  You must delete all sections
+Entitled "Endorsements".
 
 
 6. COLLECTIONS OF DOCUMENTS
@@ -272,18 +301,20 @@
 
 A compilation of the Document or its derivatives with other separate
 and independent documents or works, in or on a volume of a storage or
-distribution medium, does not as a whole count as a Modified Version
-of the Document, provided no compilation copyright is claimed for the
-compilation.  Such a compilation is called an "aggregate", and this
-License does not apply to the other self-contained works thus compiled
-with the Document, on account of their being thus compiled, if they
-are not themselves derivative works of the Document.
+distribution medium, is called an "aggregate" if the copyright
+resulting from the compilation is not used to limit the legal rights
+of the compilation's users beyond what the individual works permit.
+When the Document is included an aggregate, this License does not
+apply to the other works in the aggregate which are not themselves
+derivative works of the Document.
 
 If the Cover Text requirement of section 3 is applicable to these
-copies of the Document, then if the Document is less than one quarter
-of the entire aggregate, the Document's Cover Texts may be placed on
-covers that surround only the Document within the aggregate.
-Otherwise they must appear on covers around the whole aggregate.
+copies of the Document, then if the Document is less than one half of
+the entire aggregate, the Document's Cover Texts may be placed on
+covers that bracket the Document within the aggregate, or the
+electronic equivalent of covers if the Document is in electronic form.
+Otherwise they must appear on printed covers that bracket the whole
+aggregate.
 
 
 8. TRANSLATION
@@ -294,10 +325,17 @@
 permission from their copyright holders, but you may include
 translations of some or all Invariant Sections in addition to the
 original versions of these Invariant Sections.  You may include a
-translation of this License provided that you also include the
-original English version of this License.  In case of a disagreement
-between the translation and the original English version of this
-License, the original English version will prevail.
+translation of this License, and all the license notices in the
+Document, and any Warrany Disclaimers, provided that you also include
+the original English version of this License and the original versions
+of those notices and disclaimers.  In case of a disagreement between
+the translation and the original version of this License or a notice
+or disclaimer, the original version will prevail.
+
+If a section in the Document is Entitled "Acknowledgements",
+"Dedications", or "History", the requirement (section 4) to Preserve
+its Title (section 1) will typically require changing the actual
+title.
 
 
 9. TERMINATION
@@ -335,19 +373,23 @@
 the License in the document and put the following copyright and
 license notices just after the title page:
 
-      Copyright (c)  YEAR  YOUR NAME.
-      Permission is granted to copy, distribute and/or modify this document
-      under the terms of the GNU Free Documentation License, Version 1.1
-      or any later version published by the Free Software Foundation;
-      with the Invariant Sections being LIST THEIR TITLES, with the
-      Front-Cover Texts being LIST, and with the Back-Cover Texts being LIST.
-      A copy of the license is included in the section entitled "GNU
-      Free Documentation License".
-
-If you have no Invariant Sections, write "with no Invariant Sections"
-instead of saying which ones are invariant.  If you have no
-Front-Cover Texts, write "no Front-Cover Texts" instead of
-"Front-Cover Texts being LIST"; likewise for Back-Cover Texts.
+    Copyright (c)  YEAR  YOUR NAME.
+    Permission is granted to copy, distribute and/or modify this document
+    under the terms of the GNU Free Documentation License, Version 1.2
+    or any later version published by the Free Software Foundation;
+    with no Invariant Sections, no Front-Cover Texts, and no Back-Cover Texts.
+    A copy of the license is included in the section entitled "GNU
+    Free Documentation License".
+
+If you have Invariant Sections, Front-Cover Texts and Back-Cover Texts,
+replace the "with...Texts." line with this:
+
+    with the Invariant Sections being LIST THEIR TITLES, with the
+    Front-Cover Texts being LIST, and with the Back-Cover Texts being LIST.
+
+If you have Invariant Sections without Cover Texts, or some other
+combination of the three, merge those two alternatives to suit the
+situation.
 
 If your document contains nontrivial examples of program code, we
 recommend releasing these examples in parallel under your choice of
