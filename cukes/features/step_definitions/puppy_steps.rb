When /^I am looking at the available puppies$/ do
  on(PuppyList).wait_for_text 'Hanna'
end

Then /^I can see that "(.*?)" is available for adoption$/ do |name|
  on(PuppyList) do |screen|
    view = screen.send "#{name.downcase}_view"
    view.should have_text name
  end
end
